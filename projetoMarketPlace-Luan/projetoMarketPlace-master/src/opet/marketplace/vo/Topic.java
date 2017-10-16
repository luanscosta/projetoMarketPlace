package opet.marketplace.vo;

import java.util.Date;

/**
 * Topic.  
 * Classe dedicada a dar os parâmetros de um tópico
 * @author  Luan Costa e Gabriel Adamante
 *
 */
public class Topic {
	private int topicId;
	private String topicSubject;
	private Date topicDate;
	private Categories topicCategory;
	private String topicMessage;
	private int topicBy;

	/**
	 * Topic. Construtor padrão
	 * @param topicId
	 * @param topicSubject
	 * @param topicMessage
	 * @param topicDate
	 * @param topicCategory
	 * @param topicBy
	 */
	public Topic(int topicId, String topicSubject, String topicMessage, Date topicDate, Categories topicCategory, int topicBy) {
		this.topicId = topicId;
		this.topicSubject = topicSubject;
		this.topicDate = topicDate;
		this.topicCategory = topicCategory;
		this.topicBy = topicBy;
		this.topicMessage = topicMessage;
	}

	/**
	 * @return topicId
	 */
	public int getTopicId() {
		return this.topicId;
	}

	/**
	 * @param topicId
	 */
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	/**
	 * @return topicSubject
	 */
	public String getTopicSubject() {
		return this.topicSubject;
	}

	/**
	 * @param topicSubject
	 */
	public void setTopicSubject(String topicSubject) {
		this.topicSubject = topicSubject;
	}

	/**
	 * @return topicDate
	 */
	public Date getTopicDate() {
		return this.topicDate;
	}

	/**
	 * @param topicDate
	 */
	public void setTopicDate(Date topicDate) {
		this.topicDate = topicDate;
	}

	/**
	 * @return topicCategory
	 */
	public Categories getTopicCategory() {
		return this.topicCategory;
	}

	/**
	 * @param topicCategory
	 */
	public void setTopicCategory(Categories topicCategory) {
		this.topicCategory = topicCategory;
	}

	/**
	 * @return topicBy
	 */
	public int getTopicBy() {
		return this.topicBy;
	}

	/**
	 * @param topicBy
	 */
	public void setTopicBy(int topicBy) {
		this.topicBy = topicBy;
	}

	/**
	 * @return topicMessage
	 */
	public String getTopicMessage() {
		return topicMessage;
	}

	/**
	 * @param topicMessage
	 */
	public void setTopicMessage(String topicMessage) {
		this.topicMessage = topicMessage;
	}

}
