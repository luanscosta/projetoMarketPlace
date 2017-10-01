/**
 * 
 */
package opet.marketplace.vo;
import java.util.Date;

import opet.marketplace.vo.User;

/**
 * @author contabikiller
 *
 */
public class Client extends User {

	/**
	 * @param pId
	 * @param pName
	 * @param pPass
	 * @param pEmail
	 * @param pCreationTime
	 */
	public Client(int pId, String pName, String pPass, String pEmail, Date pCreationTime) {
		super(pId, pName, pPass, pEmail, pCreationTime);
		// TODO Auto-generated constructor stub
	}

}
