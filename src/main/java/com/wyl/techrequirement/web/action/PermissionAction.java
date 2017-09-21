package com.wyl.techrequirement.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wyl.techrequirement.domain.Permission;
import com.wyl.techrequirement.query.PageList;
import com.wyl.techrequirement.query.PermissionQuery;
import com.wyl.techrequirement.service.IPermissionService;

public class PermissionAction extends CRUDAction<Permission> {
	private IPermissionService permissionService;// setter
	private PageList pageList;// getter
	// 当前模型的属性:栈顶对象：
	private Permission permission;
	// 实例化一个查询对象,定义为baseQuery的目的，抽取公共的分页页面：getter,setter
	private PermissionQuery baseQuery = new PermissionQuery();
	// 多定义一个属性perId,所有是否保存还行修改代码判断都写userId：getter,setter
	private Long perId;

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Override
	protected void list() throws Exception {
		this.pageList = permissionService.findByQuery(baseQuery);
	}

	public String input() throws Exception {
		return INPUT;
	}

	public void validateSave() {
		if (StringUtils.isBlank(permission.getPerName())) {
			// <s:textfield name="name" placeholder="用户名" cssClass="col-xs-10
			// col-sm-5" />
			addFieldError("", "用户名不能为空");
		}
	}

	@Override
	// 如果出现了转换异常或者验证异常，改变默认的跳转视图名称,跳转到input方法
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		if (perId != null) {
			permissionService.update(permission);
		} else {
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			permissionService.save(permission);
		}
		return RELOAD;
	}

//	@Override
//	public String delete() throws Exception {
//		if (perId != null) {
//			permissionService.delete(perId);
//		} else {
//
//		}
//		return RELOAD;
//	}

	// ajax删除
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (perId != null) {
				if(perId == 1){
					out.print("{\"success\":false,\"msg\":\"不能删除管理员权限 \"}");
				}else{
					permissionService.delete(perId);
					out.print("{\"success\":true,\"msg\":\"删除成功 \"}");
				}
			} else {
				out.print("{\"success\":false,\"msg\":\"<font color='red'>删除失败</font>\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>异常信息：" + e.getMessage() + "</font>\"}");
		}
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		if (perId != null) {
			permission = permissionService.get(perId);// 回显数据
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (perId != null) {
			permission = permissionService.get(perId);
		} else {
			permission = new Permission();// 新增后的保存
		}
	}

	public PageList getPageList() {
		return pageList;
	}

	public PermissionQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(PermissionQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	@Override
	public Permission getModel() {
		return permission;
	}
}
