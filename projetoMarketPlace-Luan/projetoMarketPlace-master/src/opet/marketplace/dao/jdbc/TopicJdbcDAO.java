package opet.marketplace.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import opet.marketplace.dao.ITopicDAO;
import opet.marketplace.jdbc.Connector;
import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Topic;

/** TopicJdbcDAO. Conecções e processos relacionados aos tópicos. 
 * @author Luan Costa e Gabriel Adamante
 * 
 */
public class TopicJdbcDAO implements ITopicDAO {

	/**
	 * instancia uma conexao com o banco de dados
	 */
	private Connection sConnection = new Connector().connect();

	@Override
	public Topic create(Topic pTopic) {
		// criando um topico de retorno
		Topic tTopic = null;

		// transforma categoria em INT
		int categoryInt = pTopic.getTopicCategory().ordinal();

		try {
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(
					"INSERT INTO TOPICS" + "(TOPIC_ID, TOPIC_SUBJECT, TOPIC_MESSAGE, TOPIC_DATE, TOPIC_CAT, TOPIC_BY) "
							+ "VALUES(TOPIC_SEQ.NEXTVAL,?,?,?,?,?)");

			// Colocando os parï¿½metros recebidos no comando JDBC
			tPS.setString(1, pTopic.getTopicSubject());
			tPS.setString(2, pTopic.getTopicMessage());
			tPS.setDate(3, new Date(pTopic.getTopicDate().getTime()));
			tPS.setInt(4, categoryInt);
			tPS.setInt(5, pTopic.getTopicBy());

			// Executando o comando de gravaï¿½ï¿½o e salvando o nï¿½mero de
			// registros
			// incluï¿½dos

			int tQtdeReg = tPS.executeUpdate();

			// Verificando se um registro foi incluido
			if (tQtdeReg == 1) {
				// Copiando o contato para o retorno
				tTopic = pTopic;

				// Recuperando o ID gerado pelo Oracle
				// Algoritmo alternativo pois o indicado no WAR. não funcionava.
				// Cria um Statement que usa a funcao SQL currval para encontrar
				// o valor atual de uma sequencia

				Statement currvalStatement = null;
				ResultSet currvalResultSet = null;
				String sql_currval = "SELECT TOPIC_SEQ.CURRVAL FROM dual";

				currvalStatement = sConnection.createStatement();
				currvalResultSet = currvalStatement.executeQuery(sql_currval);

				// se verdadeiro, retorna a ID e coloca como parâmetro no
				// usuário que esse método retorna
				if (currvalResultSet.next()) {
					tTopic.setTopicId(

							currvalResultSet.getInt(1)

					);
				}

			}

			// Liberando os recursos JDBC

			tPS.close();
		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de inserção de topico");
		}

		return tTopic;
	}

	@Override
	public Topic recovery(int pInt) {

		// Definindo o objeto Topic de Retorno
		Topic tTopic = null;

		try {

			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("SELECT * FROM TOPICS WHERE TOPIC_ID = ?");

			// Colocando o parï¿½metro recebido no comando JDBC
			tPS.setInt(1, pInt);

			// Executando o comando e salvando o ResultSet para processar
			ResultSet tResultSet = tPS.executeQuery();

			// Verificando se um registro foi lido
			if (tResultSet.next()) {
				// Salvando o Contato para retornar depois
				tTopic = loadTopic(tResultSet);
			}

			// Liberando os recursos JDBC
			tResultSet.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do topico");

		}
		// TODO Auto-generated method stub
		return tTopic;
	}

	@Override
	public Topic update(Topic pTopic) {
		// definindo objeto de retorno
		Topic tTopic = null;

		// transformando categoria em int
		int categoryInt = pTopic.getTopicCategory().ordinal();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(
					"UPDATE TOPICS SET" + " TOPIC_SUBJECT = ?, TOPIC_MESSAGE = ?, TOPIC_CAT = ? WHERE TOPIC_ID = ?");

			// Colocando os parï¿½metros recebidos no comando JDBC
			tPS.setString(1, pTopic.getTopicSubject());
			tPS.setString(2, pTopic.getTopicMessage());
			tPS.setInt(3, categoryInt);
			tPS.setInt(4, pTopic.getTopicId());

			// Executando o comando de atualizar e salvando o nï¿½mero de
			// registros alterados
			int tQtdeReg = tPS.executeUpdate();

			// Verificando se um registro foi alterado
			if (tQtdeReg == 1) {
				// Copiando o contato para o retorno
				tTopic = pTopic;
			}

			// Liberando os recursos JDBC

			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do topico");
		}

		return tTopic;
	}

	@Override
	public boolean delete(int pInt) {
		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("DELETE FROM TOPICS" + " WHERE TOPIC_ID  = ?");

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
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de deleção do topico");
		}
		return false;
	}

	@Override
	public List<Topic> search() {
		// criando lista de Topic
		List<Topic> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("SELECT * FROM TOPICS ORDER BY UPPER(TOPIC_ID)");

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				Topic tTopic = loadTopic(tRS);

				// salva em lista
				tList.add(tTopic);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de recuperacao de lsita de topicos");
		}

		return tList;
	}

	@Override
	public List<Topic> searchBySubject(String pString) {
		// usando caracteres coringas para facilitar pesquisa
		String tSearchTopic = "%" + pString + "%";

		// cria lista de users
		List<Topic> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(

					"SELECT * FROM TOPICS WHERE UPPER(TOPIC_SUBJECT) LIKE UPPER(?) ORDER BY UPPER(TOPIC_ID)"

			);

			tPS.setString(1, tSearchTopic);

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				Topic tTopic = loadTopic(tRS);

				// salva em lista
				tList.add(tTopic);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de pesquisa por assunto na de lista de topicos");
		}

		return tList;
	}

	@Override
	public List<Topic> searchByUser(int pInt) {

		// cria lista de users
		List<Topic> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(

					"SELECT * FROM TOPICS WHERE TOPIC_BY = ?"

			);

			tPS.setInt(1, pInt);

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				Topic tTopic = loadTopic(tRS);

				// salva em lista
				tList.add(tTopic);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de pesquisa por usuario (autor) na lista de topicos");
		}

		return tList;
	}

	@Override
	public List<Topic> searchByCategory(Categories pCategory) {

		// transformando categoria em int
		int categoryInt = pCategory.ordinal();

		// cria lista de users
		List<Topic> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(

					"SELECT * FROM TOPICS WHERE TOPIC_BY = ?"

			);

			tPS.setInt(1, categoryInt);

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				Topic tTopic = loadTopic(tRS);

				// salva em lista
				tList.add(tTopic);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de pesquisa por categoria na de lista topicos");
		}

		return tList;
	}

	/**
	 *  loadTopic.  Método para processar o ResultSet.
	 * @param tResultSet
	 * @return tTopic
	 * @throws SQLException
	 */
	private Topic loadTopic(ResultSet tResultSet) throws SQLException {

		int topicId;
		String topicSubject;
		String topicMessage;
		Date topicDate;
		int topicCatInt;
		int topicBy;
		Categories topicCat;

		// Recuperando as informaï¿½ï¿½es do ResultSet e colocando objeto criado
		topicId = tResultSet.getInt("TOPIC_ID");
		topicSubject = tResultSet.getString("TOPIC_SUBJECT");
		topicMessage = tResultSet.getString("TOPIC_MESSAGE");
		topicDate = tResultSet.getDate("TOPIC_DATE");
		topicBy = tResultSet.getInt("TOPIC_BY");
		topicCatInt = tResultSet.getInt("TOPIC_CAT");

		// Faz um loop no enum categories. Se a categoria tem o mesmo ID que a
		// ordem de categorias,
		// atribui o valor da categoria a variavel topicCat
		for (Categories cat : Categories.values()) {
			if (cat.ordinal() == topicCatInt) {
				topicCat = cat;
				Topic tTopic = new Topic(topicId, topicSubject, topicMessage, topicDate, topicCat, topicBy);
				return tTopic;
			}

		}

		return null;

	}

}
