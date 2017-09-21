<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省重大技术需求征集系统</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<style type="text/css">
table {
	border-collapse: collapse;
	margin: 0 auto;
	width: 1100px;
}

table, th, td {
	border: 1px solid white;
}

td {
	text-align: center;
	height: 29px;
	font-size: 13px;
}

.btn {
	font-size: 15px;
	background-color: DeepSkyBlue;
	color: white;
}

.btn1 {
	font-size: 12px;
	background-color: DeepSkyBlue;
	color: white;
}

.add {
	font-size: 15px;
	background-color: DeepSkyBlue;
	color: white;
	padding: 4px;
	border: 2px solid white;
}

a {
	text-decoration: none;
}

span {
	font-size: 14px;
	color: white;
}

div {
	text-align: center;
}
</style>
<body>
	<br />
	<center>
		<%-- 				<s:debug /> --%>
		<s:form id="domainForm" action="user">
			<%-- <s:textfield name="baseQuery.currentPage" /> --%>
			用户名: <s:textfield name="baseQuery.userName" placeholder="用户名" />&nbsp;&nbsp;
			机构名称: <s:textfield name="baseQuery.userJGMC" placeholder="机构名称" />&nbsp;&nbsp;
			管理处室: <s:select style="height:23px;" list="#allDepts"
				name="baseQuery.deptId" listValue="deptName" listKey="deptId"
				headerKey="-1" headerValue="---------------请选择---------------" />&nbsp;
			<button href="javascript:;" onclick="go(1);" class="btn">搜索
			</button>&nbsp;&nbsp;
			<a href="user_input.action" class="add">添加</a>
			<br />
			<br />
			<table>
				<tr style="background-color: DodgerBlue;">
					<td width="10%"><span>用户名</span></td>
					<td width="10%"><span>Email</span></td>
					<td width="10%"><span>手机</span></td>
					<td><span>机构名称</span></td>
					<td width="10%"><span>角色</span></td>
					<td width="10%"><span>审核部门</span></td>
					<td colspan="2" width="10%"><span>操作</span></td>
					<td width="5%"><span>密码</span></td>
				</tr>
				<s:iterator value="pageList.rows">
					<tr
						<s:if test="userId==#parameters['userId'][0]">style="color: red"</s:if>>
						<td>${userName}</td>
						<td>${userYX}</td>
						<td>${userSJ}</td>
						<td>${userJGMC}</td>
						<%-- <td><s:if test="roles.size()>0">${roles}</s:if></td> --%>
						<td><s:iterator value="roles" status="sta">
								<s:if test="#sta.last">${roleName}</s:if>
								<s:else>${roleName},</s:else>
							</s:iterator></td>
						<td>${department.deptName}</td>
						<td><button type="button" class="btn1"
								onclick="updateDomain('user_input.action?userId=${userId}');">编辑</button></td>
						<td><button type="button" class="btn1"
								onclick="deleteDomain('user_delete.action?userId=${userId}');">删除</button></td>
						<td><button type="button" class="btn1"
								onclick="resetDomain('user_reset.action?userId=${userId}');">重置</button></td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/views/common/page.jsp"%>
		</s:form>
	</center>
</body>
</html>