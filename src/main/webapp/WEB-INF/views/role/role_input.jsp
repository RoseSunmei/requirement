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
.grey {
	background-color: SkyBlue;
}

.tbright {
	text-align: right;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
	width: 800px;
}

table, th, td {
	border: 0px solid black;
}

td {
	height: 30px;
}

input {
	width: 200px;
}
  
.btn {
	width: 50px;
	height: 30px;
	font-size: 15px;
	background-color: DeepSkyBlue;
	position: relative;
	color: white;
	font-size: 13px;
}

span {
	color: red;
	font-size: 12px;
}
</style>
<script type="text/javascript">
	function Check1() {
		var reg = /^[0-9a-zA-Z]+$/; //数字和字母
		var roleName = document.getElementById("roleName").value;
		if (roleName == "") {
			alert("角色名称不能为空");
			return false;
		} else if (roleName.length > 50) {
			alert("角色名称过长");
			return false;
		} else {
			document.getElementById("role_inputForm").submit();
		}
	}
</script>
<body>
	<br />
<%-- 	<s:debug /> --%>
	<s:form action="role_save" id="role_inputForm">
		<s:hidden name="roleId" />
		<table>
			<tr>
				<td class="grey" width="180px;">角色操作</td>
				<td class="grey"><font color="red" size="1px;"></font></td>
			</tr>
		</table>
		<br />
		<table>
			<tr>
				<td class="tbright" width="300px;">角色名称：</td>
				<td><s:textfield id="roleName" name="roleName"
						placeholder="角色名称" /></td>
						<td></td>
			</tr>
			<tr>
				<td class="tbright" valign="top">当前角色的权限列表：</td>
				<td style="text-align: left;"><s:checkboxlist style="width:15px;"
						list="#allPermissions" name="ids" listValue="perName" listKey="perId" />
				</td>
				<td width="12%"></td>
			</tr>
		</table> 
		<br />
		<table> 
			<tr>
				<td style="text-align: center;" colspan="3"><s:submit
						id="btnsave" class="btn" value="保存" onclick="return Check1()" />
					<button class="btn" id="cancelBtn" type="button">取消</button></td>
					<td width="5%"></td>
			</tr>
		</table> 
	</s:form>
</body>
</html>