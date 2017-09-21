package com.wyl.techrequirement.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wyl.techrequirement.domain.Role;
import com.wyl.techrequirement.domain.User;
import com.wyl.techrequirement.service.IUserService;

public class RegisterAction extends CRUDAction<User> {
	private IUserService userService;// setter
	private User user;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public void validateSave() {
		if (StringUtils.isBlank(user.getUserName())) {
			addFieldError("erroeMsg", "用户名不能为空");
		}
	}

	@InputConfig(methodName = "execute")
	public String save() throws Exception {
		user.getRoles().add(new Role(4L));
		userService.save(user);
		return LOGIN;
	}

	public String left() throws Exception {
		return "left";
	}

	public String right() throws Exception {
		return "right";
	}

	public String zhuce() throws Exception {
		return "right";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	protected void list() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepareInput() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void prepareSave() throws Exception {

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 处理ajax验证用户名是否重复
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// out.print("{\"valid\":true}");用户名可以注册
	// out.print("{\"valid\":false}");用户名重复
	public String checkName() throws Exception {
		System.out.println("checkName:" + userName);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//false:用户名重复
		//true:该用户名不重复
		out.print(userService.findByName(userName));
		return null;
	}

}
