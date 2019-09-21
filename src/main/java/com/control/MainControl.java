package com.control;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Project;
import com.entity.User;
import com.service.ProjectService;
import com.service.UserService;

/**
 * @author Administrator
 * @date 2019��9��19��
 * @version 1.0
 */
@Controller
public class MainControl {
	@Autowired
	UserService us;// 用户service接口
	@Autowired
	ProjectService ps;// 项目service接口

	// 首页
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showIndex(Model model) {

		return "login";
	}

	// 登录进入主页
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, HttpSession httpSession) {
			
		User user = us.getUser(map);
		if(null==user) {
			return "login";
		}
		httpSession.setAttribute("user", user);
		return "index";
	}

	// 立项页面
	
	@RequestMapping(value = "/saveProject", method = RequestMethod.GET)
	public String saveProject(Model model) {
		us.queryUsersByPosition(model);
		return "saveProject";
	}

	// 企业领导立项
	@ResponseBody
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public int saveProject(Project project,String[] staffs) {
		System.out.println(Arrays.toString(staffs));
		return ps.saveProject(project,staffs); 
	}

	// 企业查看所有项目
	@RequestMapping(value = "/getAllProjects")
	public String getAllProjects(Model model) {
		ps.getAllProjects(model);
		return "showProjects";
	}

}
