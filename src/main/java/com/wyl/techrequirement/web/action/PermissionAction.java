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
	// ��ǰģ�͵�����:ջ������
	private Permission permission;
	// ʵ����һ����ѯ����,����ΪbaseQuery��Ŀ�ģ���ȡ�����ķ�ҳҳ�棺getter,setter
	private PermissionQuery baseQuery = new PermissionQuery();
	// �ඨ��һ������perId,�����Ƿ񱣴滹���޸Ĵ����ж϶�дuserId��getter,setter
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
			// <s:textfield name="name" placeholder="�û���" cssClass="col-xs-10
			// col-sm-5" />
			addFieldError("", "�û�������Ϊ��");
		}
	}

	@Override
	// ���������ת���쳣������֤�쳣���ı�Ĭ�ϵ���ת��ͼ����,��ת��input����
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

	// ajaxɾ��
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (perId != null) {
				if(perId == 1){
					out.print("{\"success\":false,\"msg\":\"����ɾ������ԱȨ�� \"}");
				}else{
					permissionService.delete(perId);
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
		if (perId != null) {
			permission = permissionService.get(perId);// ��������
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (perId != null) {
			permission = permissionService.get(perId);
		} else {
			permission = new Permission();// ������ı���
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
