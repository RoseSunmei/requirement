package com.wyl.techrequirement.query;

import org.apache.commons.lang.StringUtils;

import com.wyl.techrequirement.domain.User;

/**
 * 
 * 子类自己的查询条件：用户名，email，部门
 *
 */
public class UserQuery extends BaseQuery {
	
	private String userName;
	private String userJGMC;
	private Long deptId;

	public UserQuery() {
		super(User.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(userName)) {
			addCondition("o.userName like ?", "%" + userName + "%");
		}
		if (StringUtils.isNotBlank(userJGMC)) {
			addCondition("o.userJGMC like ?", "%" + userJGMC + "%");
		}
		if (deptId != null && deptId != -1L) {
			addCondition("o.department.deptId=?", deptId);
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserJGMC() {
		return userJGMC;
	}

	public void setUserJGMC(String userJGMC) {
		this.userJGMC = userJGMC;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
}
