package com.wyl.techrequirement.web.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wyl.techrequirement.domain.Area;
import com.wyl.techrequirement.domain.Putunder;
import com.wyl.techrequirement.domain.Requirement;
import com.wyl.techrequirement.domain.State;
import com.wyl.techrequirement.domain.User;
import com.wyl.techrequirement.query.BaseQuery;
import com.wyl.techrequirement.query.PageList;
import com.wyl.techrequirement.query.RequirementQuery;
import com.wyl.techrequirement.service.IAreaService;
import com.wyl.techrequirement.service.IDepartmentService;
import com.wyl.techrequirement.service.IPutunderService;
import com.wyl.techrequirement.service.IRequirementService;
import com.wyl.techrequirement.service.IStateService;
import com.wyl.techrequirement.service.IUserService;

public class RequirementAction extends CRUDAction<Requirement> {
	private IRequirementService requirementService;// setter
	private IStateService stateService;// setter
	private IUserService userService;// setter
	private IDepartmentService departmentService;// setter
	private IPutunderService putunderService;// setter
	private IAreaService areaService;// setter
	private PageList pageList;// getter
	private User user;
	private Requirement requirement;
	private RequirementQuery baseQuery = new RequirementQuery();
	
	private Long reqId;

	public void setRequirementService(IRequirementService requirementService) {
		this.requirementService = requirementService;
	}

	public void setStateService(IStateService stateService) {
		this.stateService = stateService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setPutunderService(IPutunderService putunderService) {
		this.putunderService = putunderService;
	}

	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}

	@Override
	public Requirement getModel() {
		return requirement;
	}

	@Override
	protected void list() throws Exception {
		baseQuery.setUserId(getLoginUser().getUserId());
		this.pageList = userService.findByQuery(baseQuery);
	}

	@Override
	public String input() throws Exception {
		putContext("allPuts", putunderService.getAll());
		putContext("allAreas", areaService.getAll());
		return INPUT;
	}

	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		Putunder putunder = requirement.getPutunder();
		Area area = requirement.getArea();
		if (putunder != null && putunder.getPutId() == -1) {
			requirement.setPutunder(null);
		}
		if (area != null && area.getAreaId() == -1) {
			requirement.setArea(null);
		}
		if (reqId == null) {
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			requirement.setState(new State(1L));
			requirement.setUser(getLoginUser());
			requirement.setReqNum(requirementService.findReqNum());
			requirementService.save(requirement);
		} else {
			requirementService.update(requirement);
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
			if (reqId != null) {
				if(requirementService.get(reqId).getState().getStaId() != 1L){
					out.print("{\"success\":false,\"msg\":\"无法删除已经审核或者锁定的需求\"}");
				}else{
					requirementService.delete(reqId);
					out.print("{\"success\":true,\"msg\":\"删除成功\"}");
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
	//关键字回显
	List<String> gjzList = new ArrayList<>();

	public List<String> getGjzList() {
		return gjzList;
	}

	public void setGjzList(List<String> gjzList) {
		this.gjzList = gjzList;
	}
	//需求技术所属领域复选框回显
	List<String> sslyList = new ArrayList<>();

	public List<String> getSslyList() {
		return sslyList;
	}

	public void setSslyList(List<String> sslyList) {
		this.sslyList = sslyList;
	}
	//三级下拉单回显学科分类
	List<String> xkflList = new ArrayList<>();

	public List<String> getXkflList() {
		return xkflList;
	}

	public void setXkflList(List<String> xkflList) {
		this.xkflList = xkflList;
	}
	//三级下拉单回显需求技术应用行业
	List<String> yyhyList = new ArrayList<>();

	public List<String> getYyhyList() {
		return yyhyList;
	}

	public void setYyhyList(List<String> yyhyList) {
		this.yyhyList = yyhyList;
	}

	@Override
	public void prepareInput() throws Exception {
		if (reqId != null) {
			// 回显数据
			requirement = requirementService.get(reqId);
			//关键字回显
			String[] reqGJZ = requirement.getReqGJZ().split(",");
			for (String str : reqGJZ) {
				gjzList.add(str.trim());
			}
			System.out.println(gjzList);
			//需求技术所属领域复选框回显
			String[] reqSSLY = requirement.getReqXQJSSSLY().split(",");
			for (String str : reqSSLY) {
				sslyList.add(str.trim());
			}
			//三级下拉单回显
			String[] reqXKFL = requirement.getReqXKFL().split(",");
			for (String str : reqXKFL) {
				xkflList.add(str.trim());
			}
			//三级下拉单回显需求技术应用行业
			String[] reqYYHY = requirement.getReqXQJSYYHY().split(",");
			for (String str : reqYYHY) {
				yyhyList.add(str.trim());
			}
		}
		user = userService.get(getLoginUser().getUserId());// 回显用户数据
	}

	@Override
	public void prepareSave() throws Exception {
		if (reqId != null) {
			requirement = requirementService.get(reqId);
			requirement.setPutunder(null);
			requirement.setArea(null);
		} else {
			requirement = new Requirement();
		}

	}

	public PageList getPageList() {
		return pageList;
	}

	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}

	public RequirementQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(RequirementQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
