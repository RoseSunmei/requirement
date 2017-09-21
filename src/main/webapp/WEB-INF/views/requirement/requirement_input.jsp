<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省重大技术需求征集系统</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript" src="/js/jquery-1.4.js"></script>
<script type="text/javascript" src="/js/table.js"></script>
<script type="text/javascript" src="/sanji/sanji.js"></script>
<script type="text/javascript" src="/sanji/sanji1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		getFirst_xq('reqXQJSYYHY1');
		getFirst_xk('reqXKFL1');
	});
</script>
<!-- ****************************************************************************CSS -->
<style type="text/css">
table {
	border-collapse: collapse;
	margin: 0 auto;
	width: 900px;
}

table, th, td {
	border: 1px solid black;
}

td {
	height: 40px;
}

input {
	/* background: none transparent scroll repeat 0% 0%; */
	width: 99.5%;
	height: 40px;
	border: none;
}

div {
	text-align: center
}

span {
	color: red;
	position: relative;
	bottom: -2px;
}

.btn {
	width: 60px;
	height: 30px;
	font-size: 16px;
	background-color: DeepSkyBlue;
	color: white;
}

.gjz {
	width: 100px;
	border: 1px solid black;
}

.gjz1 {
	width: 100px;
	border: 1px solid black;
	background-color: LightGrey;
}
</style>
</head>
<body>
	<center>
		<br />
<%-- 		<s:debug /> --%>
		<s:form action="requirement_save" id="requirement_inputForm">
			<s:hidden id="reqId" name="reqId" />
			<s:hidden name="baseQuery.currentPage" />
			<s:hidden name="baseQuery.pageSize" />
			<font size="5px;">河北省重大技术需求征集表</font>
			<br />
			带<font color="red" size="5px;"> * </font>为必填内容
			<%@include file="/WEB-INF/views/requirement/requirement_top.jsp"%>
			<%@include file="/WEB-INF/views/requirement/requirement_middle.jsp"%>
			<%@include file="/WEB-INF/views/requirement/requirement_bottom.jsp"%>
			<br />
			<button type="submit" id="btnbcbtj" class="btn"
				onclick="return Check1()">保存</button>
			<button class="btn" id="cancelBtn" type="button">取消</button>
		</s:form>
		<br />
	</center>
</body>
</html>