package opet.marketplace.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import opet.marketplace.dao.IReplyDAO;
import opet.marketplace.jdbc.Connector;
import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Reply;
import opet.marketplace.vo.Topic;

/**
 *  ReplyJdbcDAO. Conecções e processos relacionados as Reply`s. 
 * @author Luan Costa e Gabriel Adamante
 *
 */
public class ReplyJdbcDAO implements IReplyDAO {
	
	/**
	 *  instancia uma conexao com o banco de dados
	 */
	private Connection sConnection = new Connector().connect();
	

	@Override
	public Reply create(Reply pReply) {
		// criando um topico de retorno
		Reply tReply = null;

		try {
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(
					"INSERT INTO REPLIES" + "(REPLY_ID, REPLY_CONTENT, REPLY_DATE, REPLY_TOPIC, REPLY_BY) "
							+ "VALUES(REPLIES_SEQ.NEXTVAL,?,?,?,?)");

			// Colocando os parï¿½metros recebidos no comando JDBC
			tPS.setString(1, pReply.getReplyContent());
			tPS.setDate(2, new Date(pReply.getReplyDate().getTime()));
			tPS.setInt(3, pReply.getReplyTopic());
			tPS.setInt(4, pReply.getReplyBy());

			// Executando o comando de gravaï¿½ï¿½o e salvando o nï¿½mero de
			// registros
			// incluï¿½dos

			int tQtdeReg = tPS.executeUpdate();

			// Verificando se um registro foi incluido
			if (tQtdeReg == 1) {
				// Copiando o contato para o retorno
				tReply = pReply;

				// Recuperando o ID gerado pelo Oracle
				// Algoritmo alternativo pois o indicado no WAR. não funcionava.
				// Cria um Statement que usa a funcao SQL currval para encontrar
				// o valor atual de uma sequencia

				Statement currvalStatement = null;
				ResultSet currvalResultSet = null;
				String sql_currval = "SELECT REPLIES_SEQ.CURRVAL FROM dual";

				currvalStatement = sConnection.createStatement();
				currvalResultSet = currvalStatement.executeQuery(sql_currval);

				// se verdadeiro, retorna a ID e coloca como parâmetro no
				// usuário que esse método retorna
				if (currvalResultSet.next()) {
					tReply.setReplyId(

							currvalResultSet.getInt(1)

					);
				}

			}

			// Liberando os recursos JDBC

			tPS.close();
		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de inserção de resposta");
		}

		return tReply;
	}

	@Override
	public Reply recovery(int pInt) {

		// Definindo o objeto Reply de Retorno
		Reply tReply = null;

		try {

			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("SELECT * FROM REPLIES WHERE REPLY_ID = ?");

			// Colocando o parï¿½metro recebido no comando JDBC
			tPS.setInt(1, pInt);

			// Executando o comando e salvando o ResultSet para processar
			ResultSet tResultSet = tPS.executeQuery();

			// Verificando se um registro foi lido
			if (tResultSet.next()) {
				// Salvando o Contato para retornar depois
				tReply = loadReply(tResultSet);
			}

			// Liberando os recursos JDBC
			tResultSet.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do reply");

		}
		// TODO Auto-generated method stub
		return tReply;
	}

	@Override
	public Reply update(Reply pReply) {
		// definindo objeto de retorno
				Reply tReply = null;

				try {
					// Criando o comando SQL e o comando JDBC
					PreparedStatement tPS = null;
					tPS = sConnection.prepareStatement(
							"UPDATE REPLIES SET REPLY_CONTENT = ? WHERE REPLY_ID = ?");

					// Colocando os parï¿½metros recebidos no comando JDBC
					tPS.setString(1, pReply.getReplyContent());
					tPS.setInt(2, pReply.getReplyId());

					// Executando o comando de atualizar e salvando o nï¿½mero de
					// registros alterados
					int tQtdeReg = tPS.executeUpdate();

					// Verificando se um registro foi alterado
					if (tQtdeReg == 1) {
						// Copiando o contato para o retorno
						tReply = pReply;
					}

					// Liberando os recursos JDBC

					tPS.close();

				} catch (SQLException tExcept) {
					opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do replyo");
				}

				return tReply;
	}

	@Override
	public boolean delete(int pInt) {
		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("DELETE FROM REPLIES" + " WHERE REPLY_ID  = ?");

			// Colocando o parï¿½metro recebido no comando JDBC
			tPS.setInt(1, pInt);

			// Executando o comando de remoï¿½ï¿½o e salvando o nï¿½mero de
			// registros removidos
			int tQtdeReg = tPS.executeUpdate();

			// Liberando os recursos JDBC
			tPS.close();

			// Se excluiu um registro, a remoção foi efetuada com sucesso
			return tQtdeReg == 1;
		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de deleção do reply");
		}
		return false;
	}

	@Override
	public List<Reply> search() {
		// criando lista de Reply
				List<Reply> tList = new ArrayList<>();

				try {
					// Criando o comando SQL e o comando JDBC
					PreparedStatement tPS = null;
					tPS = sConnection.prepareStatement("SELECT * FROM REPLIES ORDER BY UPPER(REPLY_ID)");

					// Jogando resultados em resultset e executando PS

					ResultSet tRS = tPS.executeQuery();

					// loop para processar os resultados em lista

					while (tRS.next()) {
						// usando o método loadUser para ler o contato e o instanciar em
						// tUser

						Reply tReply = loadReply(tRS);

						// salva em lista
						tList.add(tReply);

					}

					tRS.close();
					tPS.close();

				} catch (SQLException tExcept) {
					opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
							"Erro no método de recuperacao de lsita de reply");
				}

				return tList;
	}

	@Override
	public List<Reply> searchByContent(String pString) {
		// usando caracteres coringas para facilitar pesquisa
		String tSearchReply = "%" + pString + "%";

		// cria lista de users
		List<Reply> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(

					"SELECT * FROM REPLIES WHERE UPPER(REPLY_CONTENT) LIKE UPPER(?) ORDER BY UPPER(REPLY_ID)"

			);

			tPS.setString(1, tSearchReply);

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				Reply tReply = loadReply(tRS);

				// salva em lista
				tList.add(tReply);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de pesquisa por mensagem na de lista de replys");
		}

		return tList;
	}

	@Override
	public List<Reply> searchByUser(int pInt) {

		// cria lista de users
		List<Reply> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(

					"SELECT * FROM REPLIES WHERE REPLY_BY = ?"

			);

			tPS.setInt(1, pInt);

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				Reply tReply = loadReply(tRS);

				// salva em lista
				tList.add(tReply);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de pesquisa por usuario (autor) na lista de reply");
		}

		return tList;
	}

	@Override
	public List<Reply> searchByTopic(int pInt) {
		// cria lista de users
		List<Reply> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(

					"SELECT * FROM REPLIES WHERE REPLY_TOPIC = ?"

			);

			tPS.setInt(1, pInt);

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				Reply tReply = loadReply(tRS);

				// salva em lista
				tList.add(tReply);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de pesquisa por topico na lista de reply");
		}

		return tList;
	}
	
	/**
	 *  loadReply.  Método para processar o ResultSet.
	 * @param tResultSet
	 * @return tReply
	 * @throws SQLException
	 */
	private Reply loadReply(ResultSet tResultSet) throws SQLException {

		int replyId;
		String replyContent;
		Date replyDate;
		int replyTopic;
		int replyBy;

		// Recuperando  ResultSet e colocando objeto criado
		replyId = tResultSet.getInt("REPLY_ID");
		replyContent = tResultSet.getString("REPLY_CONTENT");
		replyDate = tResultSet.getDate("REPLY_DATE");
		replyTopic = tResultSet.getInt("REPLY_TOPIC");
		replyBy = tResultSet.getInt("REPLY_BY");

		Reply tReply = new Reply(replyId, replyContent, replyDate, replyTopic, replyBy);
		
		return tReply;

	}

}
