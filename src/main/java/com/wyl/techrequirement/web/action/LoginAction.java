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

	// ��ʾ��¼ҳ��
	@Override
	public String execute() throws Exception {
		return LOGIN;
	}

	public void validateCheck() {
		if (StringUtils.isBlank(user)) {
			addFieldError("msg","�û�������Ϊ��");
		}
		if (StringUtils.isBlank(pwd)) {
			addFieldError("msg","���벻��Ϊ��");
		}
		if (StringUtils.isBlank(randcode)) {
			addFieldError("msg","��֤�벻��Ϊ��");
		}
	}

	// �����¼����
	@InputConfig(resultName = LOGIN)
	public String check() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessionCode = (String)request.getSession().getAttribute("rand");
		if(!sessionCode.equals(randcode)){
			putContext("msg","��֤�����");
			return LOGIN;
		}
		User user1 = userService.findByLogin(user, pwd);
		if (user1 != null) {
			// ����user����session
			ActionContext.getContext().getSession().put(USER_IN_SESSION, user1);
			// �ض�����ҳ
			return "main";
		}
		putContext("msg","�û������������");
		return LOGIN;
	}

	public String logout() throws Exception {
		// ֻ�Ƴ�һ������
		// ActionContext.getContext().getSession().remove(USER_IN_SESSION);
		// ServletActionContext.getRequest().getSession().removeAttribute(USER_IN_SESSION);
		// ��httpSession���������ȫ�����
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
