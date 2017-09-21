package com.wyl.techrequirement.domain;

public class Department {
	
	private Long deptId;//部门id
	private String deptName;//部门名字
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Deptment [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}
