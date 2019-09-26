package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Dept;
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
	 * @param userId
	 * @return
	 */
	User getUserById(String userId);
	/**
	 * @param projectId
	 * @return
	 */
	List<User> getUsersByStaff(String projectId);
	/**
	 * @param position
	 * @return
	 */
	List<User> queryUsersByPosition(String position);
	/**
	 * @param deptNo
	 * @return
	 */
	List<User> queryUsersByDept(int deptNo);
	/**
	 * @return
	 */
	List<Dept> getAllDepts();
	/**
	 * @param deptNo
	 * @return
	 */
	Dept getDeptById(int deptNo);
	/**
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * @return
	 */
	User getBoss();
	
}
