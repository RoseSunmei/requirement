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
	padding: 3px;
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
<%-- 		<s:debug /> --%>
		<s:form id="domainForm" action="requirement">
			<%-- <s:textfield name="baseQuery.currentPage" /> --%>
			技术需求名称: <s:textfield name="baseQuery.reqJSXQMC" placeholder="技术需求名称" />&nbsp;&nbsp;
			<button href="javascript:;" onclick="go(1);" class="btn">搜索
			</button>&nbsp;&nbsp;
			<a href="requirement_input.action" class="add">添加技术需求</a>
			<br />
			<br />
			<table>
				<tr style="background-color: DodgerBlue;">
					<td width="20%"><span>需求编号</span></td>
					<td><span>技术需求名称</span></td>
					<td width="11%"><span>需求状态</span></td>
					<td colspan="2" width="11%"><span>操作</span></td>
				</tr>
				<s:iterator value="pageList.rows">
					<tr
						<s:if test="reqId==#parameters['reqId'][0]">style="color: red"</s:if>>
						<td>${reqNum}</td>
						<td>${reqJSXQMC}</td>
						<td <s:if test="state.staId==2">style="color: red"</s:if>
							<s:if test="state.staId==3">style="color: red"</s:if>
							<s:if test="state.staId==4">style="color: blue"</s:if>
							<s:if test="state.staId==5">style="color: red"</s:if>
							<s:if test="state.staId==6">style="color: blue"</s:if>>${state.staName}</td>
						<s:if test="state.staId==1">
							<td><button type="button" class="btn1"
									onclick="updateDomain('requirement_input.action?reqId=${reqId}');">编辑</button></td>
						</s:if>
						<s:else>
							<td><button type="button" class="btn1"
									onclick="updateDomain('requirementTJCX_input.action?reqId=${reqId}');">查看</button></td>
						</s:else>
						<td><button type="button" class="btn1"
								onclick="deleteDomain('requirement_delete.action?reqId=${reqId}');">删除</button></td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/views/common/page.jsp"%>
		</s:form>
	</center>
</body>
</html>