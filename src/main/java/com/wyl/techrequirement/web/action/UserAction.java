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
	// ��ǰģ�͵����ԣ�
	private User user;
	// ʵ����һ����ѯ����,����ΪbaseQuery��Ŀ�ģ���ȡ�����ķ�ҳҳ�棺getter,setter
	private UserQuery baseQuery = new UserQuery();
	// �ඨ��һ������userId,�����Ƿ񱣴滹���޸Ĵ����ж϶�дuserId��getter,setter
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
		// ���һ�������б���������ѯ
		putContext("allDepts", departmentService.getAll());
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		// ���һ�������б�����ѡ����
		putContext("allDepts", departmentService.getAll());
		// ���һ����ɫ�б�����ѡ���ɫ
		putContext("allRoles", roleService.getAll());
		return INPUT;
	}

	// ֻ��save����������֤���ǿգ����ȣ���ʽ
	public void validateSave() {
		logger.debug("validateSave");
		if (StringUtils.isBlank(user.getUserName())) {
			// <s:textfield name="userName" placeholder="�û���"/>
			addFieldError("userName", "�û�������Ϊ��");
		}
	}

	@Override
	// ���������ת���쳣������֤�쳣���ı�Ĭ�ϵ���ת��ͼ����,��ת��input����
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		logger.debug("save");
		// ���û��ѡ����
		Department department = user.getDepartment();
		if (department != null && department.getDeptId() == -1L) {
			user.setDepartment(null);
		}
		// ��ids���employee_role�м��
		if (ids != null) {
			for (Long id : ids) {
				user.getRoles().add(new Role(id));
			}
		}
		if (userId == null) {
			// �޸ĵ�ǰ��ҳ��
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			userService.save(user);
		} else {
			userService.update(user);
		}
		return RELOAD;
	}

	// ajaxɾ��
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
					if("����Ա".equals(role.getRoleName())){
						flag = 1;
					}
				}
				if(flag == 0){
					userService.delete(userId);
					out.print("{\"success\":true,\"msg\":\"ɾ���ɹ�\"}");
				}else{
					out.print("{\"success\":false,\"msg\":\"����ɾ������Ա\"}");
				}
			} else {
				out.print("{\"success\":false,\"msg\":\"ɾ��ʧ�ܣ�û�ж�Ӧ������\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>�쳣��Ϣ��" + e.getMessage() + "</font>\"}");
		}
		// return RELOAD;�����д��
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		logger.debug("prepareInput");
		if (userId != null) {
			user = userService.get(userId);// ��������
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
			user = userService.get(userId);// �����޸ĺ�û�г�����jspҳ������Բ���ʧ
			// ��ʱuser��ʲô״̬���־�״̬
			// �ı�user��Department�����ǳ־�״̬
			user.setDepartment(null);
			user.getRoles().clear();
		} else {
			user = new User();// ������ı���
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

	// ����ajax��֤�û����Ƿ��ظ�
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// out.print("{\"valid\":true}");�û�������ע��
	// out.print("{\"valid\":false}");�û����ظ�
	public String checkName() throws Exception {
		System.out.println("checkName:" + userName);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(userId);
		if (userId == null) {// ����ֱ����֤�û����Ƿ��ظ�
			out.print(userService.findByName(userName));
		} else {
			// �޸�:���û���޸��û����Ͳ�����֤
			// ����id��ȡԭ�����û���(���ݿ�������û���)
			User oldUser = userService.get(userId);
			System.out.println(oldUser.getUserName());
			String olduserName = oldUser.getUserName();
			if (olduserName.equals(userName)) {
				// û�и��û���������Ҫ��֤
				out.print(true);
			} else {
				out.print(userService.findByName(userName));
			}
		}
		return null;
	}

	// menu�˵�
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

	// ��������
	public String reset() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (userId != null) {
				user = userService.get(userId);
				user.setUserPwd("123456");
				userService.update(user);
				out.print("{\"success\":true,\"msg\":\"��������ɹ�\"}");
			} else {
				out.print("{\"success\":false,\"msg\":\"<font color='red'>��������ʧ��</font>\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>�쳣��Ϣ��" + e.getMessage() + "</font>\"}");
		}
		return NONE;
	}
}
