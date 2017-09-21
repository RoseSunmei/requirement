package com.wyl.techrequirement.domain;

public class Area {

	private Long areaId;
	private String areaCode;
	private String areaName;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaCode=" + areaCode + ", areaName=" + areaName + "]";
	}

}
