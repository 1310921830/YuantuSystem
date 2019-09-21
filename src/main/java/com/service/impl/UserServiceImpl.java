package com.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import com.util.Md5Util;

/**
* @author Administrator
* @date 2019��8��26��
* @version 1.0
*/

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserMapper um;//����dao����û��ӿ�
	
	/**
	 * @param user
	 * @return Ӱ������
	 * @see um�ӿڵ�saveUser����
	 * �û�ע��
	 */
	@Override
	public int saveUser(User user) {
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		String password=null;
		try {
			password = Md5Util.encrypt("111111");//����
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setUserId(id);
		user.setPwd(password);
		
		return um.saveUser(user);
	}
	
	/**
	 * @param map
	 * @return User����
	 * @see um�ӿڵ�getUser����
	 * �û���¼
	 */
	@Override
	public User getUser(Map<String, String> map) {
		String password=null;
		try {
			password = Md5Util.encrypt(map.get("pwd"));//����
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("pwd",password);
		return um.getUser(map);
	}

	
	@Override
	public void queryUsersByPosition(Model model) {
		model.addAttribute("deptManagers",um.queryUsersByPosition("部门经理") );
		model.addAttribute("projectManagers",um.queryUsersByPosition("项目经理") );
		model.addAttribute("emps",um.queryUsersByPosition("普通员工") );
		
	}

}
