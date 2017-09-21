package com.wyl.techrequirement.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Long userId; // 用户id
	private String userName;// 用户名
	private String userPwd;// 用户密码
	private String userZSXM; // 真实姓名
	private Long userSFZ; // 身份证
	private String userYX; // 邮箱
	private Long userSJ; // 手机
	private Long userJGDM; // 机构代码
	private String userJGMC; // 机构名称
	private Long userYZBM; // 邮政编码
	private Department department; // 部门
	// 多对多：当前用户拥有的角色列表
	private Set<Role> roles = new HashSet<Role>();
	
	public User(){
		
	}
	
	public User(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserZSXM() {
		return userZSXM;
	}

	public void setUserZSXM(String userZSXM) {
		this.userZSXM = userZSXM;
	}

	public Long getUserSFZ() {
		return userSFZ;
	}

	public void setUserSFZ(Long userSFZ) {
		this.userSFZ = userSFZ;
	}

	public String getUserYX() {
		return userYX;
	}

	public void setUserYX(String userYX) {
		this.userYX = userYX;
	}

	public Long getUserSJ() {
		return userSJ;
	}

	public void setUserSJ(Long userSJ) {
		this.userSJ = userSJ;
	}

	public Long getUserJGDM() {
		return userJGDM;
	}

	public void setUserJGDM(Long userJGDM) {
		this.userJGDM = userJGDM;
	}

	public String getUserJGMC() {
		return userJGMC;
	}

	public void setUserJGMC(String userJGMC) {
		this.userJGMC = userJGMC;
	}

	public Long getUserYZBM() {
		return userYZBM;
	}

	public void setUserYZBM(Long userYZBM) {
		this.userYZBM = userYZBM;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userZSXM=" + userZSXM
				+ ", userSFZ=" + userSFZ + ", userYX=" + userYX + ", userSJ=" + userSJ + ", userJGDM=" + userJGDM
				+ ", userJGMC=" + userJGMC + ", userYZBM=" + userYZBM + "]";
	}
	
}
