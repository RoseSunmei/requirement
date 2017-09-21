package com.wyl.techrequirement.domain;

public class Requirement {

	private State state;// 状态多对一
	private User user;// 用户多对一
	private Long reqId;// 征集表id
	private String reqNum;// 征集表编号
	private int reqXSSH;// 形式审核
	private String reqXSSHYJ;// 形式审核意见
	private int reqBMSH;// 部门审核
	private String reqBMSHYJ;// 部门审核意见
	private Department department;// 管理处室多对一
	private Putunder putunder;// 归口管理部门多对一
	private Area area;// 地域多对一
	private String reqJGMC;// 机构名称
	private String reqTXDZ;// 通讯地址
	private String reqDWWZ;// 单位网址
	private String reqDZYX;// 电子邮箱
	private String reqFRDB;// 法人代表
	private String reqYZBM;// 邮政编码
	private String reqLXR;// 联系人
	private String reqGDDH;// 固定电话
	private String reqYDDH;// 移动电话
	private String reqCZ;// 传真
	private String reqJGSX;// 机构属性
	private String reqJGJJ;// 机构简介
	private String reqJSXQMC;// 技术需求名称
	private int reqQSXQNF;// 起始需求年份
	private int reqJZXQNF;// 截止需求年份
	private String reqJSXQGS;// 技术需求概述
	private String reqJSXQGS1;// 技术需求概述1
	private String reqJSXQGS2;// 技术需求概述2
	private String reqGJZ;// 关键字
	private String reqYJLX;// 研究类型
	private String reqXKFL;// 学科分类
	private String reqXQJSSSLY;// 需求技术所属领域
	private String reqQTJSMS;// 其他技术描述
	private String reqXQJSYYHY;// 需求技术应用行业
	private String reqJSXQHZMS;// 技术需求合作模式
	private String reqHZYXDW;// 合作意向单位
	private String reqJHZTZ;// 计划总投资

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public String getReqNum() {
		return reqNum;
	}

	public void setReqNum(String reqNum) {
		this.reqNum = reqNum;
	}

	public int getReqXSSH() {
		return reqXSSH;
	}

	public void setReqXSSH(int reqXSSH) {
		this.reqXSSH = reqXSSH;
	}

	public String getReqXSSHYJ() {
		return reqXSSHYJ;
	}

	public void setReqXSSHYJ(String reqXSSHYJ) {
		this.reqXSSHYJ = reqXSSHYJ;
	}

	public int getReqBMSH() {
		return reqBMSH;
	}

	public void setReqBMSH(int reqBMSH) {
		this.reqBMSH = reqBMSH;
	}

	public String getReqBMSHYJ() {
		return reqBMSHYJ;
	}

	public void setReqBMSHYJ(String reqBMSHYJ) {
		this.reqBMSHYJ = reqBMSHYJ;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Putunder getPutunder() {
		return putunder;
	}

	public void setPutunder(Putunder putunder) {
		this.putunder = putunder;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getReqJGMC() {
		return reqJGMC;
	}

	public void setReqJGMC(String reqJGMC) {
		this.reqJGMC = reqJGMC;
	}

	public String getReqTXDZ() {
		return reqTXDZ;
	}

	public void setReqTXDZ(String reqTXDZ) {
		this.reqTXDZ = reqTXDZ;
	}

	public String getReqDWWZ() {
		return reqDWWZ;
	}

	public void setReqDWWZ(String reqDWWZ) {
		this.reqDWWZ = reqDWWZ;
	}

	public String getReqDZYX() {
		return reqDZYX;
	}

	public void setReqDZYX(String reqDZYX) {
		this.reqDZYX = reqDZYX;
	}

	public String getReqFRDB() {
		return reqFRDB;
	}

	public void setReqFRDB(String reqFRDB) {
		this.reqFRDB = reqFRDB;
	}

	public String getReqYZBM() {
		return reqYZBM;
	}

	public void setReqYZBM(String reqYZBM) {
		this.reqYZBM = reqYZBM;
	}

	public String getReqLXR() {
		return reqLXR;
	}

	public void setReqLXR(String reqLXR) {
		this.reqLXR = reqLXR;
	}

	public String getReqGDDH() {
		return reqGDDH;
	}

	public void setReqGDDH(String reqGDDH) {
		this.reqGDDH = reqGDDH;
	}

	public String getReqYDDH() {
		return reqYDDH;
	}

	public void setReqYDDH(String reqYDDH) {
		this.reqYDDH = reqYDDH;
	}

	public String getReqCZ() {
		return reqCZ;
	}

	public void setReqCZ(String reqCZ) {
		this.reqCZ = reqCZ;
	}

	public String getReqJGSX() {
		return reqJGSX;
	}

	public void setReqJGSX(String reqJGSX) {
		this.reqJGSX = reqJGSX;
	}

	public String getReqJGJJ() {
		return reqJGJJ;
	}

	public void setReqJGJJ(String reqJGJJ) {
		this.reqJGJJ = reqJGJJ;
	}

	public String getReqJSXQMC() {
		return reqJSXQMC;
	}

	public void setReqJSXQMC(String reqJSXQMC) {
		this.reqJSXQMC = reqJSXQMC;
	}

	public int getReqQSXQNF() {
		return reqQSXQNF;
	}

	public void setReqQSXQNF(int reqQSXQNF) {
		this.reqQSXQNF = reqQSXQNF;
	}

	public int getReqJZXQNF() {
		return reqJZXQNF;
	}

	public void setReqJZXQNF(int reqJZXQNF) {
		this.reqJZXQNF = reqJZXQNF;
	}

	public String getReqJSXQGS() {
		return reqJSXQGS;
	}

	public void setReqJSXQGS(String reqJSXQGS) {
		this.reqJSXQGS = reqJSXQGS;
	}

	public String getReqJSXQGS1() {
		return reqJSXQGS1;
	}

	public void setReqJSXQGS1(String reqJSXQGS1) {
		this.reqJSXQGS1 = reqJSXQGS1;
	}

	public String getReqJSXQGS2() {
		return reqJSXQGS2;
	}

	public void setReqJSXQGS2(String reqJSXQGS2) {
		this.reqJSXQGS2 = reqJSXQGS2;
	}

	public String getReqGJZ() {
		return reqGJZ;
	}

	public void setReqGJZ(String reqGJZ) {
		this.reqGJZ = reqGJZ;
	}

	public String getReqYJLX() {
		return reqYJLX;
	}

	public void setReqYJLX(String reqYJLX) {
		this.reqYJLX = reqYJLX;
	}

	public String getReqXKFL() {
		return reqXKFL;
	}

	public void setReqXKFL(String reqXKFL) {
		this.reqXKFL = reqXKFL;
	}

	public String getReqXQJSSSLY() {
		return reqXQJSSSLY;
	}

	public void setReqXQJSSSLY(String reqXQJSSSLY) {
		this.reqXQJSSSLY = reqXQJSSSLY;
	}

	public String getReqQTJSMS() {
		return reqQTJSMS;
	}

	public void setReqQTJSMS(String reqQTJSMS) {
		this.reqQTJSMS = reqQTJSMS;
	}

	public String getReqXQJSYYHY() {
		return reqXQJSYYHY;
	}

	public void setReqXQJSYYHY(String reqXQJSYYHY) {
		this.reqXQJSYYHY = reqXQJSYYHY;
	}

	public String getReqJSXQHZMS() {
		return reqJSXQHZMS;
	}

	public void setReqJSXQHZMS(String reqJSXQHZMS) {
		this.reqJSXQHZMS = reqJSXQHZMS;
	}

	public String getReqHZYXDW() {
		return reqHZYXDW;
	}

	public void setReqHZYXDW(String reqHZYXDW) {
		this.reqHZYXDW = reqHZYXDW;
	}

	public String getReqJHZTZ() {
		return reqJHZTZ;
	}

	public void setReqJHZTZ(String reqJHZTZ) {
		this.reqJHZTZ = reqJHZTZ;
	}

}
