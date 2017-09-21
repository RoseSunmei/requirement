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
	// ��ǰģ�͵�����:ջ������
	private Role role;
	// ʵ����һ����ѯ����,����ΪbaseQuery��Ŀ�ģ���ȡ�����ķ�ҳҳ�棺getter,setter
	private RoleQuery baseQuery = new RoleQuery();
	// �ඨ��һ������roleId,�����Ƿ񱣴滹���޸Ĵ����ж϶�дroleId��getter,setter
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	// ��ӽ���Ȩ�޵�id����,�����м��role_permission��getter,setter
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
		// ���һ��Ȩ���б�����ѡ��Ȩ��
		putContext("allPermissions", permissionService.getAll());
		return INPUT;
	}

	public void validateSave() {
		if (StringUtils.isBlank(role.getRoleName())) {
			// <s:textfield name="name" placeholder="�û���" cssClass="col-xs-10
			// col-sm-5" />
			addFieldError("", "��ɫ������Ϊ��");
		}
	}

	@Override
	// ���������ת���쳣������֤�쳣���ı�Ĭ�ϵ���ת��ͼ����,��ת��input����
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		logger.debug("save��" + Arrays.toString(ids));
		// ���������м������Ҫ�������棬
		// �������棺�����ɫͬʱ����Ȩ�ޣ��м��role_permission
		// ֻ�����ɫ���м��role_permission���Ƿ񱣴�ؼ���Role�Ƿ��в����м���Ȩ��
		// <set name="permissions"
		// table="role_permission">��Ϊinverse��ֵ��false���Լ�����
		if (ids != null) {
			for (Long id : ids) {
				// ͨ��id��ȡȨ�޶��󣺳־�״̬
				// role.getPermissions().add(permissionService.get(id));
				// ����һ����id����ʱȨ�޶���
				role.getPermissions().add(new Permission(id));
			}
		}
		if (roleId == null) {
			// �޸ĵ�ǰ��ҳ��
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			roleService.save(role);
		} else {
			roleService.update(role);
		}
		return RELOAD;
	}

	// ajaxɾ��
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (roleId != null) {
				if(roleId == 1){
					out.print("{\"success\":false,\"msg\":\"�޷�ɾ������Ա��ɫ \"}");
				}else{
					roleService.delete(roleId);
					out.print("{\"success\":true,\"msg\":\"ɾ���ɹ� \"}");
				}
			} else {
				out.print("{\"success\":false,\"msg\":\"<font color='red'>ɾ��ʧ��</font>\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>�쳣��Ϣ��" + e.getMessage() + "</font>\"}");
		}
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		logger.debug("prepareInput");
		if (roleId != null) {
			role = roleService.get(roleId);// ��������
			// ��ǰ��ɫ��ȫ��Ȩ���б�
			Set<Permission> permissions = role.getPermissions();
			// ��ʼ��ids����
			ids = new Long[permissions.size()];
			// ��permissions�����id����ids����
			int index = 0;
			for (Permission permission : permissions) {
				ids[index++] = permission.getPerId();
			}
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (roleId != null) {
			role = roleService.get(roleId);// �����޸ĺ�û�г�����jspҳ������Բ���ʧ
			// role.setDepartment(null);
			// role.setPermissions(null);// ��ָ���쳣
			// role.setPermissions(new HashSet<Permission>());
			role.getPermissions().clear();
		} else {
			role = new Role();// ������ı���
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
