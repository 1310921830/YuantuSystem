package com.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.entity.User;

/**
* @author Administrator
* @date 2019��8��26��
* @version 1.0
*/
public interface UserService {
	
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
	 * @param model
	 * @param position
	 */
	void queryUsersByPosition(Model model);
}
