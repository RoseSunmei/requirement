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

span {
	font-size: 14px;
	color: white;
}

div {
	text-align: center;
}

select {
	width: 120px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#xsqb").click(function() {
			window.location.href = "requirementTJCX.action"
		})
	})
</script>
<body>
	<br />
	<center>
		<%-- 		<s:debug /> --%>
		<s:form id="domainForm" action="requirementTJCX">
			<table style="border: none;">
				<tr>
					<td style="border: none;">机构名称: <s:textfield
							name="baseQuery.reqJGMC" placeholder="机构名称" />&nbsp;&nbsp; 机构属性:<s:textfield
							name="baseQuery.reqJGSS" placeholder="机构属性" />&nbsp;&nbsp;
						技术需求名称: <s:textfield name="baseQuery.reqJSXQMC"
							placeholder="技术需求名称" />&nbsp;&nbsp;关键字: <s:textfield
							name="baseQuery.reqGJZ" placeholder="关键字" /><br /> <br />
						归口管理单位: <s:select list="#allPuts" name="baseQuery.putId"
							listValue="putName" listKey="putId" headerKey="-1"
							headerValue="------请选择------" />&nbsp; 所在地域: <s:select
							list="#allAreas" name="baseQuery.areaId" listValue="areaName"
							listKey="areaId" headerKey="-1" headerValue="------请选择------" />&nbsp;&nbsp;
						管理处室: <s:select list="#allDepts" name="baseQuery.deptId"
							listValue="deptName" listKey="deptId" headerKey="-1"
							headerValue="------请选择------" />&nbsp;&nbsp; 审核状态: <s:select
							list="#allStas" name="baseQuery.staId" listValue="staName"
							listKey="staId" headerKey="-1" headerValue="------请选择------" />
						&nbsp;&nbsp;
						<button href="javascript:;" onclick="go(1);" class="btn">搜索
						</button>
					</td>
				</tr>
			</table>
			<br />
			<table>
				<tr style="background-color: DodgerBlue;">
					<td width="15%"><span>需求编号</span></td>
					<td><span>技术需求名称</span></td>
					<td width="10%"><span>需求时限</span></td>
					<td width="12%"><span>归口管理部门</span></td>
					<td width="10%"><span>地域</span></td>
					<td width="10%"><span>管理处室</span></td>
					<td width="10%"><span>审核状态</span></td>
					<td width="5%"><span>操作</span></td>
				</tr>
				<s:iterator value="pageList.rows">
					<tr
						<s:if test="reqId==#parameters['reqId'][0]">style="color: red"</s:if>>
						<td>${reqNum}</td>
						<td>${reqJSXQMC}</td>
						<td>${reqQSXQNF}-${reqJZXQNF}</td>
						<td>${putunder.putName}</td>
						<td>${area.areaName}</td>
						<td>${department.deptName}</td>
						<td>${state.staName}</td>
						<td><button type="button" class="btn1"
								onclick="updateDomain('requirementTJCX_input.action?reqId=${reqId}');">查看</button></td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/views/common/page.jsp"%>
		</s:form>
	</center>
</body>
</html>