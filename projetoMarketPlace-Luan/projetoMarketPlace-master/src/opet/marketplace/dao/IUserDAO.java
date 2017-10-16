package opet.marketplace.dao;

import java.util.List;
import opet.marketplace.vo.User;

/**
 * IUserDAO. Interface dedicada aos Users
 * 
 * @author Luan Costa e Gabriel Adamante
 * 
 */
public abstract interface IUserDAO
{
  /**
 * @param paramUser
 * @return
 */
public abstract User create(User paramUser);
  
  /**
 * @param paramInt
 * @return
 */
public abstract User recovery(int paramInt);
  
  /**
 * @param paramUser
 * @return
 */
public abstract User update(User paramUser);
  
  /**
 * @param paramInt
 * @return
 */
public abstract boolean delete(int paramInt);
  
  /**
 * @return
 */
public abstract List<User> search();
  
  /**
 * @param paramString
 * @return
 */
public abstract List<User> searchByName(String paramString);
  
  /**
 * @param paramString
 * @return
 */
public abstract List<User> searchByEmail(String paramString);
}
