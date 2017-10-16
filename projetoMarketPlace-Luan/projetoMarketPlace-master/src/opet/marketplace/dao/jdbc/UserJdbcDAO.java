package opet.marketplace.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import opet.marketplace.dao.IUserDAO;
import opet.marketplace.jdbc.Connector;
import opet.marketplace.vo.Client;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

/**
 * UserJdbcDAO. Conecçoes e processos Relacionada aos Users 
 *  
 * @author Luan Costa e Gabriel Adamante
 *
 */
public class UserJdbcDAO implements IUserDAO {

	/**
	 * instancia uma conexao com o banco de dados
	 */
	private Connection sConnection = new Connector().connect();

	public User create(User pUser) {
		// criando um usuario de retorno
		User tUser = null;

		try {
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(
					"INSERT INTO USERS" + "(USER_ID, USER_NAME, USER_PASS, USER_EMAIL, USER_CREATION_DATE, USER_TYPE) "
							+ "VALUES(USER_SEQ.NEXTVAL,?,?,?,?,?)");

			// Colocando os parï¿½metros recebidos no comando JDBC
			tPS.setString(1, pUser.getUserName());
			tPS.setString(2, pUser.getUserPass());
			tPS.setString(3, pUser.getUserEmail());
			tPS.setDate(4, new Date(pUser.getUserCreationTime().getTime()));
			if (pUser instanceof Lawyer) {
				tPS.setInt(5, 1);
			} else {
				tPS.setInt(5, 2);
			}
			;

			// Executando o comando de gravaï¿½ï¿½o e salvando o nï¿½mero de
			// registros
			// incluï¿½dos

			int tQtdeReg = tPS.executeUpdate();

			// Verificando se um registro foi incluido
			if (tQtdeReg == 1) {
				// Copiando o contato para o retorno
				tUser = pUser;

				// Recuperando o ID gerado pelo Oracle
				// Algoritmo alternativo pois o indicado no WAR. não funcionava.
				// Cria um Statement que usa a funcao SQL currval para encontrar
				// o valor atual de uma sequencia

				Statement currvalStatement = null;
				ResultSet currvalResultSet = null;
				String sql_currval = "SELECT USER_SEQ.CURRVAL FROM dual";

				currvalStatement = sConnection.createStatement();
				currvalResultSet = currvalStatement.executeQuery(sql_currval);

				// se verdadeiro, retorna a ID e coloca como parâmetro no
				// usuário que esse método retorna
				if (currvalResultSet.next()) {
					tUser.setUserId(

							currvalResultSet.getInt(1)

					);
				}

			}

			// Liberando os recursos JDBC

			tPS.close();
		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no mï¿½todo da pesquisa por e-mail dos contatos");
		}

		return tUser;
	}

	public User recovery(int pUserId) {

		// Definindo o objeto User de retorno
		User tUser = null;

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");

			// Colocando o parï¿½metro recebido no comando JDBC
			tPS.setInt(1, pUserId);

			// Executando o comando e salvando o ResultSet para processar
			ResultSet tResultSet = tPS.executeQuery();

			// Verificando se um registro foi lido
			if (tResultSet.next()) {
				// Salvando o Contato para retornar depois
				tUser = loadUser(tResultSet);
			}

			// Liberando os recursos JDBC
			tResultSet.close();
			tPS.close();
		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do usuário");
		}

		// Retornando o objeto Contato
		return tUser;
	}

	public User update(User pUser) {
		// Definindo o objeto contato de retorno
		User tUser = null;

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("UPDATE USERS SET"
					+ " USER_NAME = ?, USER_PASS = ?, USER_EMAIL = ?,USER_TYPE = ?" + " WHERE USER_ID  = ?");

			// Colocando os parï¿½metros recebidos no comando JDBC
			tPS.setString(1, pUser.getUserName());
			tPS.setString(2, pUser.getUserPass());
			tPS.setString(3, pUser.getUserEmail());

			// se for lawyer, id é 0
			if (pUser instanceof Lawyer) {

				tPS.setInt(4, 1);

			} else {

				tPS.setInt(4, 2);

			}
			tPS.setInt(5, pUser.getUserId());

			// Executando o comando de atualizar e salvando o nï¿½mero de
			// registros alterados
			int tQtdeReg = tPS.executeUpdate();

			// Verificando se um registro foi alterado
			if (tQtdeReg == 1) {
				// Copiando o contato para o retorno
				tUser = pUser;
			}

			// Liberando os recursos JDBC

			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do usuário");
		}
		return tUser;
	}

	public boolean delete(int pUserID) {

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("DELETE FROM USERS" + " WHERE USER_ID  = ?");

			// Colocando o parï¿½metro recebido no comando JDBC
			tPS.setInt(1, pUserID);

			// Executando o comando de remoï¿½ï¿½o e salvando o nï¿½mero de
			// registros removidos
			int tQtdeReg = tPS.executeUpdate();

			// Liberando os recursos JDBC
			tPS.close();

			// Se excluiu um registro, a remoção foi efetuada com sucesso
			return tQtdeReg == 1;
		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no método de deleção do contato");
		}

		// Retornando indicativo de falha de remoção
		return false;
	}

	public List<User> search() {
		// criando lista de User
		List<User> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("SELECT * FROM USERS ORDER BY UPPER(USER_ID)");

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				User tUser = loadUser(tRS);

				// salva em lista
				tList.add(tUser);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de recuperacao de lsita de contato");
		}

		return tList;

	}
	
	// método que pesquisa usuários no banco de dados a partir de nome
	public List<User> searchByName(String pName) {
		// usando caracteres coringas para facilitar pesquisa
		String tNameSearch = "%" + pName + "%";

		// cria lista de users
		List<User> tList = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement(

					"SELECT * FROM USERS WHERE UPPER(USER_NAME) LIKE UPPER(?) ORDER BY UPPER(USER_NAME)"

			);

			tPS.setString(1, tNameSearch);

			// Jogando resultados em resultset e executando PS

			ResultSet tRS = tPS.executeQuery();

			// loop para processar os resultados em lista

			while (tRS.next()) {
				// usando o método loadUser para ler o contato e o instanciar em
				// tUser

				User tUser = loadUser(tRS);

				// salva em lista
				tList.add(tUser);

			}

			tRS.close();
			tPS.close();

		} catch (SQLException tExcept) {
			opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de pesquisa por nome na de lista de contato");
		}

		return tList;

	}

	public List<User> searchByEmail(String pEmail) {
		// usando caracteres coringas para facilitar pesquisa
				String tEmailSearch = "%" + pEmail + "%";

				// cria lista de users
				List<User> tList = new ArrayList<>();

				try {
					// Criando o comando SQL e o comando JDBC
					PreparedStatement tPS = null;
					tPS = sConnection.prepareStatement(

							"SELECT * FROM USERS WHERE UPPER(USER_EMAIL) LIKE UPPER(?) ORDER BY UPPER(USER_EMAIL)"

					);

					tPS.setString(1, tEmailSearch);

					// Jogando resultados em resultset e executando PS

					ResultSet tRS = tPS.executeQuery();

					// loop para processar os resultados em lista

					while (tRS.next()) {
						// usando o método loadUser para ler o contato e o instanciar em
						// tUser

						User tUser = loadUser(tRS);

						// salva em lista
						tList.add(tUser);

					}

					tRS.close();
					tPS.close();

				} catch (SQLException tExcept) {
					opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept,
							"Erro no método de pesquisa por email na de lista de contato");
				}

				return tList;
	}

	// 
	/**
	 *  loadUser. Método para processar o ResultSet e retornar um Contato
	 * 
	 * @param tResultSet
	 * @return tUser
	 * @throws SQLException
	 */
	private User loadUser(ResultSet tResultSet) throws SQLException {

		int userId;
		String userName;
		String userPass;
		String userEmail;
		Date userDate;
		int userType;

		// Recuperando as informaï¿½ï¿½es do ResultSet e colocando objeto criado
		userId = tResultSet.getInt("USER_ID");
		userName = tResultSet.getString("USER_NAME");
		userPass = tResultSet.getString("USER_PASS");
		userEmail = tResultSet.getString("USER_EMAIL");
		userDate = tResultSet.getDate("USER_CREATION_DATE");
		userType = tResultSet.getInt("USER_TYPE");

		if (userType == 1) {
			User tUser = new Lawyer(userId, userName, userPass, userEmail, userDate);
			return tUser;
		} else {
			User tUser = new Client(userId, userName, userPass, userEmail, userDate);
			return tUser;
		}
	}
}
