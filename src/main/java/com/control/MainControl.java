package com.control;

import java.util.Map;
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
import com.entity.BigMatter;
import com.entity.Concluding;
import com.entity.Cost;
import com.entity.DailyReport;
import com.entity.Meeting;
import com.entity.Plan;
import com.entity.Project;
import com.entity.RiskReport;
import com.entity.Task;
import com.entity.User;
import com.entity.WeekReport;
import com.service.ConcludingService;
import com.service.CostService;
import com.service.DailyReportService;
import com.service.FileService;
import com.service.MatterService;
import com.service.MeetingService;
import com.service.PaddingMatterService;
import com.service.PlanService;
import com.service.ProjectService;
import com.service.RiskReportService;
import com.service.TaskService;
import com.service.UserService;
import com.service.WeekReportService;

/**
 * @author Administrator
 * @date 2019��9��19��
 * @version 1.0
 */
@Controller
public class MainControl {
	@Autowired
	FileService fs;// 文件service接口
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
	@Autowired
	MeetingService ms;// 会议记录service接口
	@Autowired
	RiskReportService rrs;// 风险报告service接口
	@Autowired
	TaskService ts;// 任务service接口
	@Autowired
	MatterService matterService;// 重大事项service接口
	@Autowired
	DailyReportService drs;// 日报service接口
	@Autowired
	WeekReportService wrs;// 周报service接口
	@Autowired
	CostService costService;// 项目支出service接口
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
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	public int updatePwd(String oldPwd, String newPwd, HttpSession httpSession) {

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

	// 部门经理审核项目计划
	@ResponseBody
	@RequestMapping(value = "/updatePlan", method = RequestMethod.POST)
	public int updatePlan(Plan plan) {
		int result = planService.updatePlan(plan);
		if (result > 0) {
			pms.updateMatter(plan.getId());
			Project project = new Project();
			project.setId(plan.getProjectId());
			project.setStatus("进行");
			ps.updateProject(project);
		}
		return result;
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

	// 企业领导审核结题报告
	@ResponseBody
	@RequestMapping(value = "/updateConcluding", method = RequestMethod.POST)
	public int updateConcluding(Concluding concluding) {
		int result = cs.updateConcluding(concluding);
		if (result > 0) {
			pms.updateMatter(concluding.getId());
			Project project = new Project();
			project.setId(concluding.getProjectId());
			project.setStatus("完成");
			ps.updateProject(project);
		}
		return result;
	}

	// 结题报告查看
	@RequestMapping(value = "/showConcluding")
	public String showConcluding(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		cs.getConcludingByProjectId(model, projectId);
		return "showConcluding";
	}

	// 从未审核事项到结题报告
	@RequestMapping(value = "/getConcluding")
	public String getConcluding(Model model, String id, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		cs.getConcludingById(model, id);
		return "showConcluding";
	}

	// 项目经理会议记录页面
	@RequestMapping(value = "/addMeeting", method = RequestMethod.GET)
	public String addMeeting(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		return "addMeeting";
	}

	// 项目经理提交会议记录
	@ResponseBody
	@RequestMapping(value = "/addMeeting", method = RequestMethod.POST)
	public int addMeeting(Meeting meeting) {
		return ms.addMeeting(meeting);
	}

	// 会议记录列表
	@RequestMapping(value = "/showMeetings", method = RequestMethod.GET)
	public String showMeetings(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		ms.queryMeetingsByProjectId(model, projectId);
		return "showMeetings";
	}

	// 会议记录详细信息
	@RequestMapping(value = "/meetingDetail", method = RequestMethod.GET)
	public String meetingDetail(Model model, String projectId, String id) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		ms.queryMeetingById(model, id);
		return "meetingDetail";
	}

	// 风险报告提交页面
	@RequestMapping(value = "/addRiskReport", method = RequestMethod.GET)
	public String addRiskReport(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		return "addRiskReport";
	}

	// 项目经理提交风险报告
	@ResponseBody
	@RequestMapping(value = "/addRiskReport", method = RequestMethod.POST)
	public int addRiskReport(RiskReport riskReport) {
		return rrs.addReport(riskReport);
	}

	// 部门经理审核风险报告
	@ResponseBody
	@RequestMapping(value = "/updateRisk", method = RequestMethod.POST)
	public int updateRisk(RiskReport riskReport) {
		int result = rrs.updateReport(riskReport);
		if (result > 0) {
			pms.updateMatter(riskReport.getId());
		}
		return result;
	}

	// 项目经理风险报告列表
	@RequestMapping(value = "/showRiskReports", method = RequestMethod.GET)
	public String showRiskReports(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		rrs.queryReportsByProjectId(model, projectId);
		return "riskReports";
	}

	// 其他人风险报告列表
	@RequestMapping(value = "/getRiskReports", method = RequestMethod.GET)
	public String getRiskReports(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		rrs.queryPassReports(model, projectId);
		;
		return "riskReports";
	}

	// 会议记录详细信息
	@RequestMapping(value = "/riskReportDetail", method = RequestMethod.GET)
	public String riskReportDetail(Model model, String projectId, String id) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		rrs.queryReportById(model, id);
		return "riskReport";
	}

	// 项目经理分配任务
	@RequestMapping(value = "/addTask", method = RequestMethod.GET)
	public String addTask(Model model, String projectId, String userId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		model.addAttribute("projectStaff", us.getUserById(userId));
		return "addTask";
	}

	// 项目经理提交任务
	@ResponseBody
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public int addTask(Task task) {
		return ts.addTask(task);
	}

	// 任务列表
	@RequestMapping(value = "/queryTasks", method = RequestMethod.GET)
	public String queryTasks(@RequestParam Map<String, Object> map, Model model) {
		// 项目信息

		model.addAttribute("project", ps.getProjectById((String) map.get("projectId")));
		ts.queryTasksByUser(model, map);
		return "taskList";
	}

	// 任务详细信息
	@RequestMapping(value = "/taskDetail", method = RequestMethod.GET)
	public String taskDetail(Model model, String projectId, String id) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		us.getProjectManager(model, project.getProjectManagerId());
		ts.queryTaskById(model, id);
		return "taskDetail";
	}

	// 部门经理发布重大事项页面
	@RequestMapping(value = "/addMatter", method = RequestMethod.GET)
	public String addMatter(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		return "addMatter";
	}

	// 部门经理提交重大事项
	@ResponseBody
	@RequestMapping(value = "/addMatter", method = RequestMethod.POST)
	public int addMatter(BigMatter matter) {
		return matterService.addMatter(matter);
	}

	// 企业领导审核重大事项
	@ResponseBody
	@RequestMapping(value = "/updateMatter", method = RequestMethod.POST)
	public int updateMatter(BigMatter matter) {
		int result = matterService.updateMatter(matter);
		if (result > 0) {
			pms.updateMatter(matter.getId());
		}
		return result;
	}

	// 部门经理重大事项列表
	@RequestMapping(value = "/showMatters", method = RequestMethod.GET)
	public String showMatters(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		matterService.queryMattersByProjectId(model, projectId);
		return "showMatters";
	}

	// 其他人重大事项列表
	@RequestMapping(value = "/getMatters", method = RequestMethod.GET)
	public String getMatters(Model model, String projectId) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		matterService.queryPassMatters(model, projectId);

		return "showMatters";
	}

	// 重大事项详细信息
	@RequestMapping(value = "/matterDetail", method = RequestMethod.GET)
	public String matterDetail(Model model, String projectId, String id) {
		// 项目信息
		Project project = ps.getProjectById(projectId);
		model.addAttribute("project", project);
		matterService.queryMatterById(model, id);
		return "matterDetail";
	}

	// 日报页面
	@RequestMapping(value = "/addDailyReport", method = RequestMethod.GET)
	public String addDailyReport(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		return "addDailyReport";
	}

	// 日报提交
	@ResponseBody
	@RequestMapping(value = "/addDailyReport", method = RequestMethod.POST)
	public int addDailyReport(DailyReport report) {
		return drs.addReport(report);
	}

	// 项目经理审核日报
	@ResponseBody
	@RequestMapping(value = "/updateDailyReport", method = RequestMethod.POST)
	public int updateDailyReport(DailyReport report) {
		int result = drs.updateReport(report);
		if (result > 0) {
			pms.updateMatter(report.getId());
		}
		return result;
	}

	// 项目成员日报列表
	@RequestMapping(value = "/showDailyReports", method = RequestMethod.GET)
	public String showDailyReports(@RequestParam Map<String, Object> map, Model model) {
		model.addAttribute("project", ps.getProjectById((String) map.get("projectId")));
		drs.queryReportsByProjectId(model, map);
		return "showDailyReports";
	}

	// 其他人日报列表
	@RequestMapping(value = "/getDailyReports", method = RequestMethod.GET)
	public String getDailyReports(Model model, String projectId) {
		// 项目信息
		model.addAttribute("project", ps.getProjectById(projectId));
		drs.queryPassReports(model, projectId);

		return "showDailyReports";
	}

	// 日报详细信息
	@RequestMapping(value = "/dailyReportDetail", method = RequestMethod.GET)
	public String dailyReportDetail(Model model, String projectId, String id) {
		// 项目信息
		model.addAttribute("project", ps.getProjectById(projectId));
		drs.queryReportById(model, id);
		return "dailyReport";
	}

	// 周报页面
	@RequestMapping(value = "/addWeekReport", method = RequestMethod.GET)
	public String addWeekReport(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		return "addWeekReport";
	}

	// 周报提交
	@ResponseBody
	@RequestMapping(value = "/addWeekReport", method = RequestMethod.POST)
	public int addWeekReport(WeekReport report) {
		Project project = new Project();
		project.setId(report.getProjectId());
		project.setProcess(report.getProcess());
		ps.updateProcess(project);
		return wrs.addReport(report);
	}

	// 部门经理审核周报
	@ResponseBody
	@RequestMapping(value = "/updateWeekReport", method = RequestMethod.POST)
	public int updateWeekReport(WeekReport report) {
		int result = wrs.updateReport(report);
		if (result > 0) {
			pms.updateMatter(report.getId());
		}
		return result;
	}

	// 项目经理周报列表
	@RequestMapping(value = "/showWeekReports", method = RequestMethod.GET)
	public String showWeekReports(Model model, String projectId) {
		model.addAttribute("project", ps.getProjectById(projectId));
		wrs.queryReportsByProjectId(model, projectId);
		return "showWeekReports";
	}

	// 其他人周报列表
	@RequestMapping(value = "/getWeekReports", method = RequestMethod.GET)
	public String getWeekReports(Model model, String projectId) {
		// 项目信息
		model.addAttribute("project", ps.getProjectById(projectId));
		wrs.queryPassReports(model, projectId);

		return "showWeekReports";
	}

	// 周报详细信息
	@RequestMapping(value = "/weekReportDetail", method = RequestMethod.GET)
	public String weekReportDetail(Model model, String projectId, String id) {
		// 项目信息
		model.addAttribute("project", ps.getProjectById(projectId));
		wrs.queryReportById(model, id);
		return "weekReport";
	}

	// 项目支出提交
	@ResponseBody
	@RequestMapping(value = "/addCost", method = RequestMethod.POST)
	public int addCost(Cost cost) {
		return costService.addCost(cost);
	}

	// 支出列表
	@RequestMapping(value = "/getCosts", method = RequestMethod.GET)
	public String getCosts(Model model, HttpSession httpSession, String projectId) {
		costService.queryCosts(model, httpSession, projectId);
		return "showCosts";
	}

	// 文件上传
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Map<String, Object> importPicFile(MultipartFile file) {
		return fs.uploadFile(file);
	}

	// 文件下载
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response, String path) {
		fs.downloadFile(request, response, path);

	}

}
