/**
 * 
 */
package opet.marketplace.vo;

import java.util.Date;

/**
 * @author contabikiller
 *
 */
public class Thread {

	private int threadId;
	private String threadSubject;
	private Date threadDate;
	private int threadCategory;
	private int topicBy;
	
	
	public Thread(int threadId, String threadSubject, Date threadDate, int threadCategory, int topicBy) {
		super();
		this.threadId = threadId;
		this.threadSubject = threadSubject;
		this.threadDate = threadDate;
		this.threadCategory = threadCategory;
		this.topicBy = topicBy;
	}


	/**
	 * @return the threadId
	 */
	public int getThreadId() {
		return threadId;
	}


	/**
	 * @param threadId the threadId to set
	 */
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}


	/**
	 * @return the threadSubject
	 */
	public String getThreadSubject() {
		return threadSubject;
	}


	/**
	 * @param threadSubject the threadSubject to set
	 */
	public void setThreadSubject(String threadSubject) {
		this.threadSubject = threadSubject;
	}


	/**
	 * @return the threadDate
	 */
	public Date getThreadDate() {
		return threadDate;
	}


	/**
	 * @param threadDate the threadDate to set
	 */
	public void setThreadDate(Date threadDate) {
		this.threadDate = threadDate;
	}


	/**
	 * @return the threadCategory
	 */
	public int getThreadCategory() {
		return threadCategory;
	}


	/**
	 * @param threadCategory the threadCategory to set
	 */
	public void setThreadCategory(int threadCategory) {
		this.threadCategory = threadCategory;
	}


	/**
	 * @return the topicBy
	 */
	public int getTopicBy() {
		return topicBy;
	}


	/**
	 * @param topicBy the topicBy to set
	 */
	public void setTopicBy(int topicBy) {
		this.topicBy = topicBy;
	}
		
}
