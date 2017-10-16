package opet.marketplace.vo;

import java.util.Date;

/**
 * Thread.  Classe dedicada a entregar os parâmetros de uma thread
 * 
 * @author  Luan Costa e Gabriel Adamante
 *
 */
public class Thread
{
  private int threadId;
  private String threadSubject;
  private Date threadDate;
  private Categories threadCategory;
  private int topicBy;
  
  /**
   * Thread.  Construtor padrão
 * @param threadId
 * @param threadSubject
 * @param threadDate
 * @param threadCategory
 * @param topicBy
 */
public Thread(int threadId, String threadSubject, Date threadDate, Categories threadCategory, int topicBy)
  {
    this.threadId = threadId;
    this.threadSubject = threadSubject;
    this.threadDate = threadDate;
    this.threadCategory = threadCategory;
    this.topicBy = topicBy;
  }
  
  /**
 * @return threadId
 */
public int getThreadId()
  {
    return this.threadId;
  }
  
  /**
 * @param threadId
 */
public void setThreadId(int threadId)
  {
    this.threadId = threadId;
  }
  
  /**
 * @return threadSubject
 */
public String getThreadSubject()
  {
    return this.threadSubject;
  }
  
  /**
 * @param threadSubject
 */
public void setThreadSubject(String threadSubject)
  {
    this.threadSubject = threadSubject;
  }
  
  /**
 * @return threadDate
 */
public Date getThreadDate()
  {
    return this.threadDate;
  }
  
  /**
 * @param threadDate
 */
public void setThreadDate(Date threadDate)
  {
    this.threadDate = threadDate;
  }
  
  /**
 * @return threadCategory
 */
public Categories getThreadCategory()
  {
    return this.threadCategory;
  }
  
  /**
 * @param threadCategory
 */
public void setThreadCategory(Categories threadCategory)
  {
    this.threadCategory = threadCategory;
  }
  
  /**
 * @return topicBy
 */
public int getTopicBy()
  {
    return this.topicBy;
  }
  
  /**
 * @param topicBy
 */
public void setTopicBy(int topicBy)
  {
    this.topicBy = topicBy;
  }
}
