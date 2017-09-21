package com.wyl.techrequirement.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wyl.techrequirement.domain.User;

/**
 * 
 * 非CRUD需求的父类
 *
 */
public class BaseAction extends ActionSupport {
	// 重定向的视图名称
	public static final String RELOAD = "reload";
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	// session里面登录用户的key
	public static final String USER_IN_SESSION = "userInSession";

	protected void putContext(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

	protected User getLoginUser() {
		return (User) ActionContext.getContext().getSession().get(USER_IN_SESSION);
	}
}
