package com.wyl.techrequirement.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wyl.techrequirement.domain.User;
import com.wyl.techrequirement.service.IUserService;

public class LoginAction extends BaseAction {
	private IUserService userService;
	private String user;
	private String pwd;
	private String randcode;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	// 显示登录页面
	@Override
	public String execute() throws Exception {
		return LOGIN;
	}

	public void validateCheck() {
		if (StringUtils.isBlank(user)) {
			addFieldError("msg","用户名不能为空");
		}
		if (StringUtils.isBlank(pwd)) {
			addFieldError("msg","密码不能为空");
		}
		if (StringUtils.isBlank(randcode)) {
			addFieldError("msg","验证码不能为空");
		}
	}

	// 处理登录请求
	@InputConfig(resultName = LOGIN)
	public String check() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessionCode = (String)request.getSession().getAttribute("rand");
		if(!sessionCode.equals(randcode)){
			putContext("msg","验证码错误");
			return LOGIN;
		}
		User user1 = userService.findByLogin(user, pwd);
		if (user1 != null) {
			// 放置user对象到session
			ActionContext.getContext().getSession().put(USER_IN_SESSION, user1);
			// 重定向到主页
			return "main";
		}
		putContext("msg","用户名或密码错误");
		return LOGIN;
	}

	public String logout() throws Exception {
		// 只移除一个属性
		// ActionContext.getContext().getSession().remove(USER_IN_SESSION);
		// ServletActionContext.getRequest().getSession().removeAttribute(USER_IN_SESSION);
		// 把httpSession里面的属性全部清除
		// ActionContext.getContext().getSession().clear();
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRandcode() {
		return randcode;
	}

	public void setRandcode(String randcode) {
		this.randcode = randcode;
	}
}
