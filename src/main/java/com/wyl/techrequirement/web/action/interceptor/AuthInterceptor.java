package com.wyl.techrequirement.web.action.interceptor;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wyl.techrequirement.domain.User;
import com.wyl.techrequirement.service.IPermissionService;
import com.wyl.techrequirement.web.action.BaseAction;

public class AuthInterceptor extends AbstractInterceptor {
	private String excludeActions;

	public AuthInterceptor() {
		System.out.println("AuthInterceptor只会调用一次+++++");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		System.out.println("AuthInterceptor访问一次，调用一次:" + action);

		// A.对一些不需要拦截的action进行放行
		// indexOf:返回指定字符在此字符串中第一次出现处的索引。,判断使用是否大于-1
		if (excludeActions.indexOf(action.getClass().getSimpleName()) > -1) {
			// 放行： 进入下一个拦截器
			return invocation.invoke();
		}

		// B.判断是否已经登录
		// 如果登录的对象没有，跳转到登录页面
		User user = (User) ActionContext.getContext().getSession().get(BaseAction.USER_IN_SESSION);
		if (user == null) {
			// <global-results>
			// <result name="login">/WEB-INF/views/login.jsp</result>
			// </global-results>
			return Action.LOGIN;
		}

		if (user.getUserId() == 1L) {
			// 放行： 进入下一个拦截器
			return invocation.invoke();
		}

		// 放行： 进入下一个拦截器
		return invocation.invoke();
	}

	public void setExcludeActions(String excludeActions) {
		this.excludeActions = excludeActions;
		System.out.println("AuthInterceptor只会调用一次+++++" + excludeActions);
	}
}
