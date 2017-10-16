package opet.marketplace.vo;

import java.util.Date;

/**
 * User
 *  Dá os parâmetros de um usuário padrão do sistema
 * @author  Luan Costa e Gabriel Adamante
 * 
 */
public class User
{
  private int userId;
  private String userName;
  private String userPass;
  private String userEmail;
  private Date userCreationTime;
  
  /**
   * User.  
   * Método construtor padrão
 * @param pId
 * @param pName
 * @param pPass
 * @param pEmail
 * @param pCreationTime
 */
public User(int pId, String pName, String pPass, String pEmail, Date pCreationTime)
  {
    this.userId = pId;
    this.userName = pName;
    this.userPass = pPass;
    this.userEmail = pEmail;
    this.userCreationTime = pCreationTime;
  }
  
  /**
 * @return userId
 */
public int getUserId()
  {
    return this.userId;
  }
  
  /**
 * @param userId
 */
public void setUserId(int userId)
  {
    this.userId = userId;
  }
  
  /**
 * @return userName
 */
public String getUserName()
  {
    return this.userName;
  }
  
  /**
 * @param userName
 */
public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  /**
 * @return userPass
 */
public String getUserPass()
  {
    return this.userPass;
  }
  
  /**
 * @param userPass
 */
public void setUserPass(String userPass)
  {
    this.userPass = userPass;
  }
  
  /**
 * @return userEmail
 */
public String getUserEmail()
  {
    return this.userEmail;
  }
  
  /**
 * @param userEmail
 */
public void setUserEmail(String userEmail)
  {
    this.userEmail = userEmail;
  }
  
  /**
 * @return userCreationTime
 */
public Date getUserCreationTime()
  {
    return this.userCreationTime;
  }
  
  /**
 * @param userCreationTime
 */
public void setUserCreationTime(Date userCreationTime)
  {
    this.userCreationTime = userCreationTime;
  }
}
