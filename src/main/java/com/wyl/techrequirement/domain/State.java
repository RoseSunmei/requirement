package com.wyl.techrequirement.domain;

public class State {

	private Long staId;// 状态id
	private String staName;// 状态名称
	
	public State(){}
	
	public State(Long staId){
		this.staId = staId;
	}

	public Long getStaId() {
		return staId;
	}

	public void setStaId(Long staId) {
		this.staId = staId;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

}
