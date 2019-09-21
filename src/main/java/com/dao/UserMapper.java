package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.User;

/**
* @author Administrator
* @date 2019��8��26��
* @version 1.0
*/
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public interface UserMapper {
	
	/**
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * @param map
	 * @return
	 */
	User getUser(Map<String, String> map);
	
	/**
	 * @param position
	 * @return
	 */
	List<User> queryUsersByPosition(String position);
}
