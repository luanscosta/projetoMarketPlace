package opet.marketplace.dao;

import java.util.List;

import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Topic;

/**
 * ITopicDAO. Interface dedicada aos Topics
 * 
 * @author Luan Costa e Gabriel Adamante
 * 
 */
public abstract interface ITopicDAO {
	  /**
	 * @param pTopic
	 * @return
	 */
	public abstract Topic create(Topic pTopic);
	  
	  /**
	 * @param pInt
	 * @return
	 */
	public abstract Topic recovery(int pInt);
	  
	  /**
	 * @param pTopic
	 * @return
	 */
	public abstract Topic update(Topic pTopic);
	  
	  /**
	 * @param pInt
	 * @return
	 */
	public abstract boolean delete(int pInt);
	  
	  /**
	 * @return
	 */
	public abstract List<Topic> search();
	  
	  /**
	 * @param pString
	 * @return
	 */
	public abstract List<Topic> searchBySubject(String pString);
	  
	  /**
	 * @param pInt
	 * @return
	 */
	public abstract List<Topic> searchByUser(int pInt);
	  
	  /**
	 * @param pCategory
	 * @return
	 */
	public abstract List<Topic> searchByCategory(Categories pCategory);
	}
