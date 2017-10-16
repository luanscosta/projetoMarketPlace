package opet.marketplace.vo;

import java.util.Date;

/**
 * Lawyer. Classe dedicada a entregar os par�metros de um Lawyer
 * @author  Luan Costa e Gabriel Adamante
 *
 */
public class Lawyer
  extends User
{
  /**
   * Lawyer. Construtor padr�o
 * @param pId
 * @param pName
 * @param pPass
 * @param pEmail
 * @param pCreationTime
 */
public Lawyer(int pId, String pName, String pPass, String pEmail, Date pCreationTime)
  {
    super(pId, pName, pPass, pEmail, pCreationTime);
  }
}
