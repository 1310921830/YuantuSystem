package com.dao;

import java.util.List;

import com.entity.Scheme;

/**
* @author Administrator
* @date 2019年9月24日
* @version 1.0
*/
public interface SchemeMapper {
	/**
	 * @param scheme
	 * @return
	 */
	int addScheme(Scheme scheme);
	/**
	 * @param projectId
	 * @return
	 */
	List<Scheme> queryReportsByProjectId(String projectId);
	/**
	 * @param projectId
	 * @return
	 */
	List<Scheme> queryPassReports(String projectId);
	/**
	 * @param id
	 * @return
	 */
	Scheme queryReportById(String id);
	/**
	 * @param scheme
	 * @return
	 */
	int updateScheme(Scheme scheme);
}
