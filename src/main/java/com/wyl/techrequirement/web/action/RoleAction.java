package com.wyl.techrequirement.web.action;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wyl.techrequirement.domain.Permission;
import com.wyl.techrequirement.domain.Role;
import com.wyl.techrequirement.query.PageList;
import com.wyl.techrequirement.query.RoleQuery;
import com.wyl.techrequirement.service.IPermissionService;
import com.wyl.techrequirement.service.IRoleService;

public class RoleAction extends CRUDAction<Role> {
	private IRoleService roleService;// setter
	private IPermissionService permissionService;
	private PageList pageList;// getter
	// 当前模型的属性:栈顶对象：
	private Role role;
	// 实例化一个查询对象,定义为baseQuery的目的，抽取公共的分页页面：getter,setter
	private RoleQuery baseQuery = new RoleQuery();
	// 多定义一个属性roleId,所有是否保存还行修改代码判断都写roleId：getter,setter
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	// 添加接受权限的id数组,处理中间表role_permission：getter,setter
	private Long[] ids;

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		this.pageList = roleService.findByQuery(baseQuery);
	}

	public String input() throws Exception {
		logger.debug("input");
		// 添加一个权限列表，用来选择权限
		putContext("allPermissions", permissionService.getAll());
		return INPUT;
	}

	public void validateSave() {
		if (StringUtils.isBlank(role.getRoleName())) {
			// <s:textfield name="name" placeholder="用户名" cssClass="col-xs-10
			// col-sm-5" />
			addFieldError("", "角色名不能为空");
		}
	}

	@Override
	// 如果出现了转换异常或者验证异常，改变默认的跳转视图名称,跳转到input方法
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		logger.debug("save：" + Arrays.toString(ids));
		// 怎样保持中间表：不需要级联保存，
		// 级联保存：保存角色同时保存权限，中间表role_permission
		// 只保存角色和中间表role_permission：是否保存关键，Role是否有操作中间表的权限
		// <set name="permissions"
		// table="role_permission">因为inverse的值是false，自己管理
		if (ids != null) {
			for (Long id : ids) {
				// 通过id获取权限对象：持久状态
				// role.getPermissions().add(permissionService.get(id));
				// 传入一个有id的临时权限对象
				role.getPermissions().add(new Permission(id));
			}
		}
		if (roleId == null) {
			// 修改当前的页码
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			roleService.save(role);
		} else {
			roleService.update(role);
		}
		return RELOAD;
	}

	// ajax删除
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (roleId != null) {
				if(roleId == 1){
					out.print("{\"success\":false,\"msg\":\"无法删除管理员角色 \"}");
				}else{
					roleService.delete(roleId);
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
		logger.debug("prepareInput");
		if (roleId != null) {
			role = roleService.get(roleId);// 回显数据
			// 当前角色的全部权限列表
			Set<Permission> permissions = role.getPermissions();
			// 初始化ids数组
			ids = new Long[permissions.size()];
			// 把permissions里面的id存入ids里面
			int index = 0;
			for (Permission permission : permissions) {
				ids[index++] = permission.getPerId();
			}
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (roleId != null) {
			role = roleService.get(roleId);// 保存修改后没有出现在jsp页面的属性不丢失
			// role.setDepartment(null);
			// role.setPermissions(null);// 空指针异常
			// role.setPermissions(new HashSet<Permission>());
			role.getPermissions().clear();
		} else {
			role = new Role();// 新增后的保存
		}
	}

	public PageList getPageList() {
		return pageList;
	}

	public RoleQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(RoleQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	@Override
	public Role getModel() {
		return role;
	}
}
