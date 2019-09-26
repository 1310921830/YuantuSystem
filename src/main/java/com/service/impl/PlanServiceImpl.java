package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.PaddingMatterMapper;
import com.dao.PlanMapper;
import com.dao.UserMapper;
import com.entity.PaddingMatter;
import com.entity.Plan;
import com.service.PlanService;
import com.util.DateUtil;

/**
 * @author Administrator
 * @date 2019年9月24日
 * @version 1.0
 */
@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	PlanMapper pm;
	@Autowired
	UserMapper um;
	@Autowired
	PaddingMatterMapper pmm;

	@Override
	public int addPlan(Plan plan) {
		String id = (new Date()).getTime() + "";
		String date = DateUtil.dateString1(new Date());
		plan.setId(id);
		plan.setDate(date);
		plan.setIsCheck("否");
		int result = pm.addPlan(plan);
		if (result > 0) {
			addPaddingMatter(plan);
		}
		return result;
	}

	@Override
	public void getPlanByProjectId(Model model, String projectId) {
		// TODO Auto-generated method stub
		Plan plan = pm.getPlanByProjectId(projectId);
		model.addAttribute("plan", plan);
		if (null != plan) {
			model.addAttribute("prepared", um.getUserById(plan.getPreparedName()));
			model.addAttribute("checked", um.getUserById(plan.getReviewedName()));
		}

	}

	@Override
	public int updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		return pm.updatePlan(plan);
	}

	@Override
	public void addPaddingMatter(Plan plan) {
		String id = (new Date()).getTime() + "";
		String date = plan.getDate();
		String title = plan.getTitle();
		String type = "项目计划";
		String linkId = plan.getId();
		String checkById = plan.getReviewedName();
		String projectId = plan.getProjectId();
		PaddingMatter paddingMatter = new PaddingMatter(id, date, title, type, linkId, checkById, projectId, 1);
		pmm.addPaddingMatter(paddingMatter);
	}

	@Override
	public void getPlanById(Model model, String id) {
		// TODO Auto-generated method stub
		Plan plan = pm.getPlanById(id);
		model.addAttribute("plan", plan);
		if (null != plan) {
			model.addAttribute("prepared", um.getUserById(plan.getPreparedName()));
			model.addAttribute("checked", um.getUserById(plan.getReviewedName()));
		}

	}

}
