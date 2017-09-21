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
<script type="text/javascript">
	$(function() {
		$("#btnbtg").click(function() {
			$("#sftg").val("否");
			if ($("#reqBMSHYJ").val() == "") {
				alert("请写明不通过的意见");
				return false;
			} else {
				if (confirm("确定提交审核吗?")) {
					alert("审核成功");
					return true;
				}else{
					return false;
				}
			}
		})
		$("#btntg").click(function() {
			$("#sftg").val("是");
			if (confirm("确定提交审核吗?")) {
				alert("审核成功");
				return true;
			}else{
				return false;
			}
		})
	})
</script>
</head>
<body>
	<center>
		<br />
<%-- 		<s:debug /> --%>
		<font size="5px;">河北省重大技术需求征集表</font> <br />带<font color="red"
			size="5px;"> * </font>为必填内容
		<%@include file="/WEB-INF/views/requirementTemp/requirementTemp.jsp"%>
		<s:form action="requirementBMSH_save">
			<s:hidden id="reqId" name="reqId" />
			<s:hidden name="baseQuery.currentPage" />
			<s:hidden name="baseQuery.pageSize" />
			<s:hidden name="sftg" id="sftg" />
			<table>
				<tr>
					<td width="120px;"><span>*</span>部门审核意见</td>
					<td><s:textarea name="reqBMSHYJ" id="reqBMSHYJ" rows="4"
							cols="91" /></td>
				</tr>
			</table>
			<br />
			<br />
			<button type="submit" id="btntg" class="btn">通过</button>
			<button type="submit" id="btnbtg" class="btn" style="width: 80px;">不通过</button>
			<br />
			<br />
		</s:form>
	</center>
</body>
</html>