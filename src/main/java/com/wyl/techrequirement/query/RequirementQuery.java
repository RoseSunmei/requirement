package com.wyl.techrequirement.query;

import org.apache.commons.lang.StringUtils;

import com.wyl.techrequirement.domain.Requirement;

/**
 * 
 * 子类自己的查询条件：用户名，email，部门
 *
 */
public class RequirementQuery extends BaseQuery {

	private Long userId;// 用户id
	private Long staId;// 状态id
	private Long deptId;// 管理处室id
	private Long putId;// 归口管理部门id
	private Long areaId;// 地域id
	private String reqJSXQMC;// 技术需求名称
	private String reqJGMC;// 机构名称
	private String reqJGSS;// 机构属性
	private String reqGJZ;// 关键字

	public RequirementQuery() {
		super(Requirement.class.getName());
	}

	@Override
	protected void addWhere() {
		if (userId != null) {
			addCondition("o.user.userId=?", userId);
		}
		if (staId != null && staId != -1L) {
			addCondition("o.state.staId=?", staId);
		}
		if (deptId != null && deptId != -1L) {
			addCondition("o.department.deptId=?", deptId);
		}
		if (putId != null && putId != -1L) {
			addCondition("o.putunder.putId=?", putId);
		}
		if (areaId != null && areaId != -1L) {
			addCondition("o.area.areaId=?", areaId);
		}
		if (StringUtils.isNotBlank(reqJSXQMC)) {
			addCondition("o.reqJSXQMC like ?", "%" + reqJSXQMC + "%");
		}
		if (StringUtils.isNotBlank(reqJGMC)) {
			addCondition("o.reqJGMC like ?", "%" + reqJGMC + "%");
		}
		if (StringUtils.isNotBlank(reqJGSS)) {
			addCondition("o.reqJGSS like ?", "%" + reqJGSS + "%");
		}
		if (StringUtils.isNotBlank(reqGJZ)) {
			addCondition("o.reqGJZ like ?", "%" + reqGJZ + "%");
		}
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStaId() {
		return staId;
	}

	public void setStaId(Long staId) {
		this.staId = staId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getPutId() {
		return putId;
	}

	public void setPutId(Long putId) {
		this.putId = putId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getReqJSXQMC() {
		return reqJSXQMC;
	}

	public void setReqJSXQMC(String reqJSXQMC) {
		this.reqJSXQMC = reqJSXQMC;
	}

	public String getReqJGMC() {
		return reqJGMC;
	}

	public void setReqJGMC(String reqJGMC) {
		this.reqJGMC = reqJGMC;
	}

	public String getReqJGSS() {
		return reqJGSS;
	}

	public void setReqJGSS(String reqJGSS) {
		this.reqJGSS = reqJGSS;
	}

	public String getReqGJZ() {
		return reqGJZ;
	}

	public void setReqGJZ(String reqGJZ) {
		this.reqGJZ = reqGJZ;
	}

}
