package com.wyl.techrequirement.domain;

public class Putunder {

	private Long putId;
	private String putName;

	public Long getPutId() {
		return putId;
	}

	public void setPutId(Long putId) {
		this.putId = putId;
	}

	public String getPutName() {
		return putName;
	}

	public void setPutName(String putName) {
		this.putName = putName;
	}

	@Override
	public String toString() {
		return "Putunder [putId=" + putId + ", putName=" + putName + "]";
	}

}
