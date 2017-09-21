package com.wyl.techrequirement.web.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wyl.techrequirement.domain.Department;
import com.wyl.techrequirement.domain.Permission;
import com.wyl.techrequirement.domain.Role;
import com.wyl.techrequirement.domain.User;
import com.wyl.techrequirement.query.PageList;
import com.wyl.techrequirement.query.UserQuery;
import com.wyl.techrequirement.service.IDepartmentService;
import com.wyl.techrequirement.service.IPermissionService;
import com.wyl.techrequirement.service.IRoleService;
import com.wyl.techrequirement.service.IUserService;

import net.sf.json.JSONSerializer;

public class UserAction extends CRUDAction<User> {
	private IUserService userService;// setter
	private IDepartmentService departmentService;
	private IRoleService roleService;
	private IPermissionService permissionService;
	private PageList pageList;// getter
	// 当前模型的属性：
	private User user;
	// 实例化一个查询对象,定义为baseQuery的目的，抽取公共的分页页面：getter,setter
	private UserQuery baseQuery = new UserQuery();
	// 多定义一个属性userId,所有是否保存还行修改代码判断都写userId：getter,setter
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private Long[] ids;

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
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
		this.pageList = userService.findByQuery(baseQuery);
		// 添加一个部门列表，用来做查询
		putContext("allDepts", departmentService.getAll());
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		// 添加一个部门列表，用来选择部门
		putContext("allDepts", departmentService.getAll());
		// 添加一个角色列表，用来选择角色
		putContext("allRoles", roleService.getAll());
		return INPUT;
	}

	// 只对save方法进行验证：非空，长度，格式
	public void validateSave() {
		logger.debug("validateSave");
		if (StringUtils.isBlank(user.getUserName())) {
			// <s:textfield name="userName" placeholder="用户名"/>
			addFieldError("userName", "用户名不能为空");
		}
	}

	@Override
	// 如果出现了转换异常或者验证异常，改变默认的跳转视图名称,跳转到input方法
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		logger.debug("save");
		// 如果没有选择部门
		Department department = user.getDepartment();
		if (department != null && department.getDeptId() == -1L) {
			user.setDepartment(null);
		}
		// 把ids变成employee_role中间表
		if (ids != null) {
			for (Long id : ids) {
				user.getRoles().add(new Role(id));
			}
		}
		if (userId == null) {
			// 修改当前的页码
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			userService.save(user);
		} else {
			userService.update(user);
		}
		return RELOAD;
	}

	// ajax删除
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (userId != null) {
				int flag = 0;
				List<Role> list = roleService.getroleName(userId);
				for (Role role : list) {
					System.out.println(role);
					if("管理员".equals(role.getRoleName())){
						flag = 1;
					}
				}
				if(flag == 0){
					userService.delete(userId);
					out.print("{\"success\":true,\"msg\":\"删除成功\"}");
				}else{
					out.print("{\"success\":false,\"msg\":\"不能删除管理员\"}");
				}
			} else {
				out.print("{\"success\":false,\"msg\":\"删除失败：没有对应的数据\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>异常信息：" + e.getMessage() + "</font>\"}");
		}
		// return RELOAD;错误的写法
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		logger.debug("prepareInput");
		if (userId != null) {
			user = userService.get(userId);// 回显数据
			Set<Role> roles = user.getRoles();
			ids = new Long[roles.size()];
			int index = 0;
			for (Role role : roles) {
				ids[index++] = role.getRoleId();
			}
		}
	}

	@Override
	public void prepareSave() throws Exception {
		logger.debug("prepareSave begin...");
		if (userId != null) {
			user = userService.get(userId);// 保存修改后没有出现在jsp页面的属性不丢失
			// 此时user是什么状态：持久状态
			// 改变user的Department不能是持久状态
			user.setDepartment(null);
			user.getRoles().clear();
		} else {
			user = new User();// 新增后的保存
		}
		logger.debug("prepareSave end...");
	}

	public UserQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(UserQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public PageList getPageList() {
		return pageList;
	}

	@Override
	public User getModel() {
		return user;
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
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(userId);
		if (userId == null) {// 新增直接验证用户名是否重复
			out.print(userService.findByName(userName));
		} else {
			// 修改:如果没有修改用户名就不用验证
			// 根据id获取原来的用户名(数据库里面的用户名)
			User oldUser = userService.get(userId);
			System.out.println(oldUser.getUserName());
			String olduserName = oldUser.getUserName();
			if (olduserName.equals(userName)) {
				// 没有改用户名，不需要验证
				out.print(true);
			} else {
				out.print(userService.findByName(userName));
			}
		}
		return null;
	}

	// menu菜单
	public String menu() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<Permission> list = permissionService.findByLoginUserId(getLoginUser().getUserId());
		for (Permission permission : list) {
			System.out.println(permission);
		}
		String json = JSONSerializer.toJSON(list).toString();
		out.print(json);
		return null;
	}

	// 重置密码
	public String reset() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (userId != null) {
				user = userService.get(userId);
				user.setUserPwd("123456");
				userService.update(user);
				out.print("{\"success\":true,\"msg\":\"重置密码成功\"}");
			} else {
				out.print("{\"success\":false,\"msg\":\"<font color='red'>密码重置失败</font>\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>异常信息：" + e.getMessage() + "</font>\"}");
		}
		return NONE;
	}
}
