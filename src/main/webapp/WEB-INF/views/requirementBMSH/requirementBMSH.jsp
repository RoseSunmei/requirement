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
	font-size: 13px;
	background-color: DeepSkyBlue;
	color: white;
}

a {
	text-decoration: none;
}

span {
	font-size: 14px;
	color: white;
}
</style>
<body>
	<br />
	<center>
		<%-- 		<s:debug /> --%>
		<s:form id="domainForm" action="requirementBMSH">
			<font size="5px;">未审核征集表清单</font>
			<table>
				<tr style="background-color: DodgerBlue;">
					<td width="15%"><span>需求编号</span></td>
					<td><span>技术需求名称</span></td>
					<td width="10%"><span>需求时限</span></td>
					<td width="15%"><span>归口管理部门</span></td>
					<td width="10%"><span>地域</span></td>
					<td width="8%"><span>操作</span></td>
				</tr>
				<s:iterator value="pageList.rows">
					<tr
						<s:if test="reqId==#parameters['reqId'][0]">style="color: red"</s:if>>
						<td>${reqNum}</td>
						<td>${reqJSXQMC}</td>
						<td>${reqQSXQNF}-${reqJZXQNF}</td>
						<td>${putunder.putName}</td>
						<td>${area.areaName}</td>
						<td><button type="button" class="btn"
								onclick="updateDomain('requirementBMSH_input.action?reqId=${reqId}');">审核</button></td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/views/common/page.jsp"%>
		</s:form>
	</center>
</body>
</html>