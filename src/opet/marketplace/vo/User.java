/**
 * 
 */
package opet.marketplace.vo;


import java.util.Date;

/**
 * @author contabikiller
 *
 */
public class User {
	
	private int userId;
	private String userName;
	private String userPass;
	private String userEmail;
	private Date userCreationTime;


	public User(int pId, String pName, String pPass, String pEmail, Date pCreationTime) {
		
		this.userId = pId;
		this.userName = pName;
		this.userPass = pPass;
		this.userEmail = pEmail;
		this.userCreationTime = pCreationTime;
		
	}


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the userPass
	 */
	public String getUserPass() {
		return userPass;
	}


	/**
	 * @param userPass the userPass to set
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}


	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	/**
	 * @return the userCreationTime
	 */
	public Date getUserCreationTime() {
		return userCreationTime;
	}


	/**
	 * @param userCreationTime the userCreationTime to set
	 */
	public void setUserCreationTime(Date userCreationTime) {
		this.userCreationTime = userCreationTime;
	}
	
	
	
}
