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

.bgzuo {
	width: 100px;
}

.zhushi {
	color: red;
	font-size: 14px;
}

.tbright {
	text-align: right;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
	width: 700px;
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
	width: 60px;
	height: 30px;
	font-size: 15px;
	background-color: DeepSkyBlue;
	position: relative;
	right: 40px;
	color: white;
	font-size: 15px;
}

span {
	color: red;
	font-size: 12px;
}
</style>
<script type="text/javascript">
	function Check1() {
		var reg = /^[0-9a-zA-Z]+$/; //数字和字母
		var perName = document.getElementById("perName").value;
		if (perName == "") {
			alert("权限名称不能为空");
			return false;
		} else if (perName.length > 50) {
			alert("权限名称过长");
			return false;
		} else {
			document.getElementById("permission_inputForm").submit();
		}
	}
</script>
<body>
	<br />
	<%-- <s:debug /> --%>
	<s:form action="permission_save" id="permission_inputForm">
		<s:hidden name="perId" />
		<table>
			<tr>
				<td class="grey" width="180px;">权限操作</td>
				<td class="grey"></td>
			</tr>
		</table>
		<br />
		<table>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">权限名称：</td>
				<td><s:textfield id="perName" name="perName" placeholder="权限名称" /></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td valign="top" class="tbright">权限说明：</td>
				<td><s:textarea id="perText" name="perText" placeholder="权限说明" rows="3"
					cols="21"></s:textarea></td>
			</tr>
		</table>
		<br />
		<table>
			<tr>
				<td style="text-align: center;" colspan="3"><s:submit
						id="btnsave" class="btn" value="保存" onclick="return Check1()" />
					<button class="btn" id="cancelBtn" type="button">取消</button></td>
			</tr>
		</table>
	</s:form>
</body>
</html>