package com.wyl.techrequirement.domain;

public class Permission {

	private Long perId;// 权限id
	private String perName;// 权限名称
	private String perText;// 权限说明

	public Permission() {

	}

	public Permission(Long perId) {
		this.perId = perId;
	}

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerText() {
		return perText;
	}

	public void setPerText(String perText) {
		this.perText = perText;
	}

	@Override
	public String toString() {
		return "Permission [perId=" + perId + ", perName=" + perName + ", perText=" + perText + "]";
	}

}
