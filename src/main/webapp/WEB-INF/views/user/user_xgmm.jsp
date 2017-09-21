<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省重大技术需求征集系统</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
	// 	$(function() {
	// 		$("#oldPwd").blur(function() {
	// 			var oldPwd = $("#oldPwd").val();
	// 			alert(oldPwd + "ssssdfq");
	// 			console.debug(22);
	// 			$.ajax({
	// 				url : "modify_checkPwd.action",
	// 				type : "post",
	// 				dataType : "json",
	// 				success : function(data) {
	// 					console.debug(data.length);
	// 					alert(0);
	// 				}
	// 			})
	// 		});
	// 	});
	var xhr;
	function createXhr() {
		try {
			xhr = new XMLHttpRequest();
		} catch (e) {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	function checkoldPwd() {
		createXhr();
		var oldPwd = document.getElementById("oldPwd").value;
		var pdoldPwd = document.getElementById("pdoldPwd");
		xhr.open("GET", "/modify_checkPwd.action?oldPwd=" + oldPwd + "&"
				+ new Date().getTime(), true);
		xhr.onreadystatechange = function() {//匿名函数
			if (xhr.readyState == 4 && xhr.status == 200) {
				var text = xhr.responseText;
				if (oldPwd == "") {
					pdoldPwd.innerHTML = "请输入旧密码";
					document.getElementById("btnupdate").disabled = true;
				} else if ("false" == text) {
					pdoldPwd.innerHTML = "旧密码错误";
					document.getElementById("btnupdate").disabled = true;
				} else {
					pdoldPwd.innerHTML = "<font color='green'>√</font>";
					document.getElementById("btnupdate").disabled = false;
				}
			}
		}
		xhr.send();
	}
	function checknewPwd() {
		var newPwd = document.getElementById("newPwd");
		var pdnewPwd = document.getElementById("pdnewPwd");
		if (newPwd.value.length > 18 || newPwd.value.length < 6) {
			pdnewPwd.innerHTML = "请输入6-18位密码";
			document.getElementById("btnupdate").disabled = true;
		} else {
			pdnewPwd.innerHTML = "<font color='green'>√</font>";
			document.getElementById("btnupdate").disabled = false;
		}
	}
	function checknewPwd1() {
		var newPwd = document.getElementById("newPwd");
		var newPwd1 = document.getElementById("newPwd1");
		var pdnewPwd1 = document.getElementById("pdnewPwd1");
		if (newPwd.value != newPwd1.value || newPwd1.value == "") {
			pdnewPwd1.innerHTML = "两次输入的密码不相同";
			document.getElementById("btnupdate").disabled = true;
		} else {
			pdnewPwd1.innerHTML = "<font color='green'>√</font>";
			document.getElementById("btnupdate").disabled = false;
		}
	}
	function Check1() {
		var oldPwd = document.getElementById("oldPwd").value;
		var newPwd = document.getElementById("newPwd").value;
		var newPwd1 = document.getElementById("newPwd1").value;
		if (oldPwd == "") {
			alert("请输入旧密码");
			return false;
		} else {
			if (confirm("确定修改密码吗?")) {
				createXhr();
				xhr.open("GET", "/modify_pwd.action?newPwd=" + newPwd + "&"
						+ new Date().getTime(), true);
				xhr.onreadystatechange = function() {//匿名函数
					if (xhr.readyState == 4 && xhr.status == 200) {
						var text = xhr.responseText;
						if ("false" == text) {
							alert("修改密码失败");
						} else {
							alert("修改成功");
						}
					}
				}
				xhr.send();
			}else{
				return false;
			}
		}
	}
</script>

<style type="text/css">
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

span {
	color: red;
	font-size: 12px;
}

.grey {
	background-color: SkyBlue;
}

.bgzuo {
	width: 110px;
}

.tbright {
	text-align: right;
}

.btn {
	width: 60px;
	height: 30px;
	font-size: 15px;
	background-color: DeepSkyBlue;
	position: relative;
	right: 30px;
	color: white;
	font-size: 15px;
}
</style>
</head>
<body>
	<br />
	<center>
		<table>
			<tr>
				<td class="grey" width="180px;">修改密码</td>
				<td class="grey"><font color="red" size="1px;"><s:fielderror /></font></td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">旧密码：</td>
				<td><s:password id="oldPwd" name="oldPwd" placeholder="旧密码"
						onblur="checkoldPwd()" /> <span id="pdoldPwd">*</span></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">新密码：</td>
				<td><s:password id="newPwd" name="newPwd" placeholder="新密码"
						onblur="checknewPwd()" /> <span id="pdnewPwd">*</span></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">确认密码：</td>
				<td><s:password id="newPwd1" name="newPwd1" placeholder="确认密码"
						onblur="checknewPwd1()" /> <span id="pdnewPwd1">*</span></td>
			</tr>
		</table>
		<br />
		<table>
			<tr>
				<td style="text-align: center;" colspan="3"><s:submit
						id="btnupdate" class="btn" value="保存" onclick="return Check1()" />
					<button class="btn" id="cancelBtn" type="button">取消</button></td>
			</tr>
		</table>
	</center>
</body>
</html>