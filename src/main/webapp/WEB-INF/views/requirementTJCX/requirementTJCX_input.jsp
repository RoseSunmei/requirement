</table><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省重大技术需求征集系统</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript" src="/js/sh.js"></script>
<link type="text/css" href="css/look.css" rel="stylesheet" />
</head>
<body>
	<center>
		<br />
		<%-- 		<s:debug /> --%>
		<font size="5px;">河北省重大技术需求征集表</font> <br />带<font color="red"
			size="5px;"> * </font>为必填内容
		<%@include file="/WEB-INF/views/requirementTemp/requirementTemp.jsp"%>
			<s:hidden id="reqId" name="reqId" />
			<s:hidden name="baseQuery.currentPage" />
			<s:hidden name="baseQuery.pageSize" />
			<table>
				<tr>
					<td width="120px;"><span>*</span>形式审核意见</td>
					<td>${reqXSSHYJ}</td>
				</tr>
				<tr>
					<td width="120px;"><span>*</span>部门审核意见</td>
					<td>${reqBMSHYJ}</td>
				</tr>
			</table>
			<br />
			<button id="cancelBtn" class="btn">返回</button>
			<br />
	</center>
</body>
</html>