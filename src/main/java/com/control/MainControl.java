package com.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Concluding;
import com.entity.Plan;
import com.entity.Project;
import com.entity.User;
import com.service.ConcludingService;
import com.service.PaddingMatterService;
import com.service.PlanService;
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
	@Autowired
	PlanService planService;// 项目计划service接口
	@Autowired
	PaddingMatterService pms;// 待办事项service接口
	@Autowired
	ConcludingService cs;// 结题报告service接口
	// 首页

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showIndex(Model model) {

		return "login";
	}

	// 登录进入主页
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, HttpSession httpSession, Model model) {

		User user = us.getUser(map);
		if (null == user) {
			return "login";
		}
		httpSession.setAttribute("user", user);
		User boss = us.getBoss();
		httpSession.setAttribute("boss", boss);
		return "index";
	}

	// 左侧菜单栏
	@RequestMapping(value = "/left", method = RequestMethod.GET)
	public String left(Model model, HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		pms.getCount(model, user.getUserId());
		return "left";
	}

	// 待办事项列表页面
	@RequestMapping(value = "/paddingMatters")
	public String paddingMatters(Model model, String userId) {

		pms.getMatters(model, userId);
		return "paddingMatters";
	}

	// 退出
	@RequestMapping(value = "/loginout")
	public String loginOut(HttpSession httpSession) {
		httpSession.removeAttribute("user");
		return "logout";
	}

	// 查看个人信息
	@RequestMapping(value = "/userInfo")
	public String userInfo(Model model, int deptNo) {
		us.getDeptById(model, deptNo);
		return "userInfo";
	}

	// 更改头像
	@ResponseBody
	@RequestMapping(value = "/changeImg")
	public int changeImg(String url, HttpSession httpSession) {

		return us.changeUserImg(url, httpSession);
	}

	// 更改密码
	@ResponseBody
	@RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
	public int updatePwd(String oldPwd,String newPwd, HttpSession httpSession) {

		return us.updatePwd(oldPwd, newPwd, httpSession);
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
	public int saveProject(Project project, String[] staffs) {
		System.out.println(Arrays.toString(staffs));
		return ps.saveProject(project, staffs);
	}

	// 企业领导查看所有项目
	@RequestMapping(value = "/getAllProjects")
	public String getAllProjects(Model model) {
		ps.getAllProjects(model);
		return "showProjects";
	}

	// 部门经理查看项目
	@RequestMapping(value = "/getDeptProjects")
	public String getDeptProjects(Model model, String deptMgId) {
		ps.getProjectsByDeptManagerId(model, deptMgId);
		return "showProjects";
	}

	// 项目经理查看项目
	@RequestMapping(value = "/getProjects")
	public String getProjects(Model model, String pjMgId) {
		ps.getProjectsByProjectManagerId(model, pjMgId);
		return "showProjects";
	}

	// 项目成员查看项目
	@RequestMapping(value = "/getSomeProjects")
	public String getSomeProjects(Model model, String userId) {
		ps.getSomeProjects(model, userId);
		return "showProjects";
	}

	// 查看项目详细信息
	@RequestMapping(value = "/projectDetail")
	public String projectDetail(String id, Model model) {
		// 项目信息
		Project project = ps.getProjectById(id);
		model.addAttribute("project", project);
		// 部门经理和项目经理
		us.getDeptManager(model, project.getDeptManagerId());
		us.getProjectManager(model, project.getProjectManagerId());
		// 项目成员
		us.getUsersByStaff(model, id);
		return "projectDetail";
	}

	// 项目经理项目计划页面
	@RequestMapping(value = "/addPlan", method = RequestMethod.GET)
	public String addPlan(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		return "addPlan";
	}

	// 项目经理提交项目计划
	@ResponseBody
	@RequestMapping(value = "/addPlan", method = RequestMethod.POST)
	public int addPlan(Plan plan) {

		return planService.addPlan(plan);
	}

	// 项目计划查看
	@RequestMapping(value = "/showPlan")
	public String showPlan(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		planService.getPlanByProjectId(model, projectId);
		return "showPlan";
	}

	// 从未审核事项到项目计划
	@RequestMapping(value = "/getPlan")
	public String getPlan(Model model, String id, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		planService.getPlanById(model, id);
		return "showPlan";
	}

	// 项目经理项目总结页面
	@RequestMapping(value = "/addConcluding", method = RequestMethod.GET)
	public String addConcluding(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		return "addConcluding";
	}

	// 项目经理提交结题报告
	@ResponseBody
	@RequestMapping(value = "/addConcluding", method = RequestMethod.POST)
	public int addConcluding(Concluding concluding) {
		return cs.addConcliuding(concluding);
	}

	// 项目计划查看
	@RequestMapping(value = "/showConcluding")
	public String showConcluding(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		cs.getConcludingByProjectId(model, projectId);
		return "showConcluding";
	}

	// 从未审核事项到项目计划
	@RequestMapping(value = "/getConcluding")
	public String getConcluding(Model model, String id, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		cs.getConcludingById(model, id);
		return "showConcluding";
	}

	// 文件上传
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Map<String, Object> importPicFile(MultipartFile file) throws IOException {
		System.out.println("adsa");
		Map<String, Object> map = new HashMap<String, Object>();
		String fileName = "";
		if (file.isEmpty()) {
			System.out.println("adsaasd");
			return map;
		} else {
			// 原始文件名称
			String originalFilename = file.getOriginalFilename();
			// 后缀
			String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();

			// 保存文件名
			fileName = getFileName() + suffix;

			// 文件保存路径
			String filePath = "F:/imgs/";
			// 新建文件
			File uploadPath = new File(filePath, fileName);
			uploadPath.createNewFile();
			// 上传
			file.transferTo(uploadPath);
			map.put("filename", fileName);
			map.put("filepath", filePath);
			return map;
		}

	}

	public String getFileName() {
		SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Random random = new Random();
		return simpledateFormat.format(new Date()) + random.nextInt(10000);

	}

	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {

		// �õ�Ҫ���ص��ļ�
		File file = new File(path);
		String filename = path.substring(path.lastIndexOf("/") + 1);
		System.out.println(filename);
		if (!file.exists()) {
			response.setContentType("text/html; charset=UTF-8");// ע��text/html����application/html
			response.getWriter().print(
					"<html><body><script type='text/javascript'>alert('��Ҫ���ص���Դ�ѱ�ɾ����');</script></body></html>");
			response.getWriter().close();
			System.out.println("��Ҫ���ص���Դ�ѱ�ɾ������");
			return;
		}
		// ת�룬����ļ�����������
		filename = URLEncoder.encode(filename, "UTF-8");
		// �����ļ�����ͷ
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.�����ļ�ContentType���ͣ��������ã����Զ��ж������ļ�����
		response.setContentType("multipart/form-data");
		// ��ȡҪ���ص��ļ������浽�ļ�������
		FileInputStream in = new FileInputStream(file);
		// ���������
		OutputStream out = response.getOutputStream();
		// ����������
		byte buffer[] = new byte[1024]; // �������Ĵ�С�����Ǹ��� ��Ҳû������
		int len = 0;
		// ѭ�����������е����ݶ�ȡ������������
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		// �ر��ļ�������
		in.close();
		// �ر������
		out.close();
	}

	/*
	 * @RequestMapping(value = "/import")
	 * 
	 * @ResponseBody public String importExcel(MultipartFile file) { String flag =
	 * "02";// �ϴ���־ if (!file.isEmpty()) { try { flag = ds.ImportExcel(file); }
	 * catch (InvalidFormatException | IOException e) { flag = "03";// �ϴ�ʧ�� }
	 * 
	 * } return flag; }
	 * 
	 * // ���Ʋ�<br>//����excel�ĵ�
	 * 
	 * @RequestMapping("/exportExcel")
	 * 
	 * @ResponseBody public void exportExcel(HttpServletRequest request,
	 * HttpServletResponse response) { try {
	 * 
	 * // ����excel response.setHeader("Content-Disposition", "attachment;filename="
	 * + new String("������Ϣ.xls".getBytes(), "ISO-8859-1"));
	 * response.setContentType("application/x-excel;charset=UTF-8"); OutputStream
	 * outputStream = response.getOutputStream(); // ����
	 * ds.exportExcel(outputStream); outputStream.close(); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
}
