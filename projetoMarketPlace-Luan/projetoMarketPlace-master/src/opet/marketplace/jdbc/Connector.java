package opet.marketplace.jdbc;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Connector.  
 * 
 * Classe dedicada a conexão ao banco de dados Oracle
 * @author  Luan Costa e Gabriel Adamante
 *
 */
public class Connector
{
  String dbUrl = "jdbc:oracle:thin:@localhost:1521:system";
  String dbUser = "system";
  String dbPassword = "system";
  PreparedStatement preparedStatement;
  ResultSet resultSet;
  Connection connection;
  
  /**
 *  Try catch dedicado a tratar a perca do driver
 *  do oracle
 */
public Connector()
  {
    try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  /**
   * Abrir a conexão + tratamento de sql exception
 * @return connection
 */
public Connection connect()
  {
    try
    {
      System.out.println("VAI ABRIR A CONEXAO");
      this.connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
      System.out.println("CONEXAO ABERTA CORRETAMENTE");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
    return this.connection;
  }
  
  /**
   * Fechar a conecão do db 
 * @throws SQLException
 */
public void disconnect()
    throws SQLException
  {
    System.out.println("VAI FECHAR A CONEXAO");
    if (this.preparedStatement != null) {
      this.preparedStatement.close();
    }
    if ((this.connection != null) && (!this.connection.isClosed()))
    {
      this.connection.close();
      System.out.println("CONEXAO FECHADA CORRETAMENTE");
    }
    else
    {
      System.out.println("CONEXAO NAO ESTAVA FECHADA");
    }
  }
}
