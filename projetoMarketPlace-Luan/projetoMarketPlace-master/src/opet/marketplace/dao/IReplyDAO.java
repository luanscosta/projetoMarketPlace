package opet.marketplace.dao;

import java.util.List;

import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Reply;

/**
 * IReplyDAO. Interdface dedicada as Reply`s
 *  
 * @author Luan Costa e Gabriel Adamante
 * 
 * 
 */
public abstract interface IReplyDAO {
	
	  /**
	 * @param pReply
	 * @return 
	 */
	public abstract Reply create(Reply pReply);
	  
	  /**
	 * @param pInt
	 * @return 
	 */
	public abstract Reply recovery(int pInt);
	  
	  /**
	 * @param pReply
	 * @return 
	 */
	public abstract Reply update(Reply pReply);
	  
	  /**
	 * @param pInt
	 * @return 
	 */
	public abstract boolean delete(int pInt);
	  
	  /**
	 * @return 
	 */
	public abstract List<Reply> search();
	  
	  /**
	 * @param pString
	 * @return
	 */
	public abstract List<Reply> searchByContent(String pString);
	  
	  /**
	 * @param pInt
	 * @return
	 */
	public abstract List<Reply> searchByUser(int pInt);
	  
	  /**
	 * @param pInt
	 * @return
	 */
	public abstract List<Reply> searchByTopic(int pInt);

}
