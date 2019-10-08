package com.dao;

import java.util.List;

import com.entity.Cost;

/**
* @author Administrator
* @date 2019年9月24日
* @version 1.0
*/
public interface CostMapper {
	/**
	 * @param cost
	 * @return
	 */
	int addCost(Cost cost);
	/**
	 * @param projectId
	 * @return
	 */
	List<Cost> queryCosts(String projectId);
	/**
	 * @param projectId
	 * @return
	 */
	List<Cost> queryCostsToDept(String projectId);
	/**
	 * @param projectId
	 * @return
	 */
	List<Cost> queryCostsToBoss(String projectId);
	/**
	 * @param id
	 * @return
	 */
	Cost queryCostById(String id);

}
