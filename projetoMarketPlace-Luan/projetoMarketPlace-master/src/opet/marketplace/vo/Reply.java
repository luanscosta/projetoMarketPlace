package opet.marketplace.vo;

import java.util.Date;

/**
 * Reply. Classe dedicada a entregar os parâmetros de uma reply
 * 
 * @author  Luan Costa e Gabriel Adamante
 *
 */
public class Reply {
	
	private int replyId;
	private String replyContent;
	private Date replyDate;
	private int replyTopic;
	private int replyBy;
	
	/**
	 * Reply. Construtor padrão
	 * @param replyId
	 * @param replyContent
	 * @param replyDate
	 * @param replyTopic
	 * @param replyBy
	 */
	public Reply(int replyId, String replyContent, Date replyDate, int replyTopic, int replyBy) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyTopic = replyTopic;
		this.replyBy = replyBy;
	}

	/**
	 * @return replyId
	 */
	public int getReplyId() {
		return replyId;
	}

	/**
	 * @param replyId
	 */
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	/**
	 * @return replyContent
	 */
	public String getReplyContent() {
		return replyContent;
	}

	/**
	 * @param replyContent
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	/**
	 * @return replyDate
	 */
	public Date getReplyDate() {
		return replyDate;
	}

	/**
	 * @param replyDate
	 */
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	/**
	 * @return replyTopic
	 */
	public int getReplyTopic() {
		return replyTopic;
	}

	/**
	 * @param replyTopic
	 */
	public void setReplyTopic(int replyTopic) {
		this.replyTopic = replyTopic;
	}

	/**
	 * @return replyBy
	 */
	public int getReplyBy() {
		return replyBy;
	}

	/**
	 * @param replyBy
	 */
	public void setReplyBy(int replyBy) {
		this.replyBy = replyBy;
	}
		
}
