package opet.marketplace.vo;

import java.util.Date;

/**
 * Client.  Classe dedicada a dar os par�metros de um Client
 * @author  Luan Costa e Gabriel Adamante
 *
 */
public class Client
  extends User
{
  /**
   * Client. Construtor padr�o
 * @param pId
 * @param pName
 * @param pPass
 * @param pEmail
 * @param pCreationTime
 */
public Client(int pId, String pName, String pPass, String pEmail, Date pCreationTime)
  {
    super(pId, pName, pPass, pEmail, pCreationTime);
  }
}
