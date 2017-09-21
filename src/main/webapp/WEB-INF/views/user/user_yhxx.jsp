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
	width: 110px;
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
	right: 30px;
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
		var userName = document.getElementById("userName").value;
		var pdName = document.getElementById("pdName");
		if (userName.length > 20 || userName.length < 6 || !reg.test(userName)) {
			alert("用户名只能由6-20个数字和英文字母组成");
			return false;
		} else {
			if (confirm("确定保存?")) {
				document.getElementById("modify_yhxxForm").submit();
			}else{
				return false;
			}
		}
	}
</script>
<body>
	<br />
	<center>
		<%-- 		<s:debug /> --%>
		<s:form action="modify_save" id="modify_yhxxForm">
			<s:hidden id="userId" name="userId" />
			<table>
				<tr>
					<td class="grey">用户名和密码</td>
				</tr>
			</table>
			<script type="text/javascript">
				var xhr;
				//统一获取XMLHttpRequest的方法
				function createXhr() {
					try {
						xhr = new XMLHttpRequest();
					} catch (e) {
						xhr = new ActiveXObject("Microsoft.XMLHTTP");
					}
				}
				function checkName() {
					var reg = /^[0-9a-zA-Z]+$/; //数字和字母
					var userName = document.getElementById("userName").value;
					var pdName = document.getElementById("pdName");
					createXhr();
					var userId = document.getElementById("userId").value;
					xhr.open("GET", "/user_checkName.action?userId=" + userId
							+ "&userName=" + userName + "&"
							+ new Date().getTime(), true);
					xhr.onreadystatechange = function() {//匿名函数
						if (xhr.readyState == 4 && xhr.status == 200) {
							var text = xhr.responseText;
							if (userName.length > 20 || userName.length < 6
									|| !reg.test(userName)) {
								pdName.innerHTML = "请输入6-20位数字或字母";
								document.getElementById("btnsave").disabled = true;
							} else if ("false" == text) {// 用户名已经存在
								pdName.innerHTML = "<font color='red'>用户名已经存在</font>";
								document.getElementById("btnsave").disabled = true;
							} else {
								pdName.innerHTML = "<font color='green'>√</font>";
								document.getElementById("btnsave").disabled = false;
							}
						}
					}
					xhr.send();
				}
			</script>
			<table>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright" width="120px;">用户名：</td>
					<td><s:textfield id="userName" name="userName"
							placeholder="用户名" onblur="checkName()" /> <span id="pdName">*</span></td>
				</tr>

			</table>
			<table>
				<tr>
					<td class="grey">用户信息</td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">真实姓名：</td>
					<td><s:textfield id="userZSXM" name="userZSXM" readonly="true" />
						<span id="pdZSXM">*不可修改</span></td>
				</tr>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright" width="120px;">身份证号：</td>
					<td><s:textfield id="userSFZ" name="userSFZ" readonly="true" />
						<span id="pdSFZ">*不可修改</span></td>
				</tr>
				<script type="text/javascript">
					function checkYX() {
						var strReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;// 判定邮箱是否正确
						var userYX = document.getElementById("userYX").value;
						var pdYX = document.getElementById("pdYX");
						if (!strReg.test(userYX)) {
							pdYX.innerHTML = "请输入正确的邮箱";
							document.getElementById("btnsave").disabled = true;
						} else {
							pdYX.innerHTML = "<font color='green'>√</font>";
							document.getElementById("btnsave").disabled = false;
						}
					}
				</script>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">电子邮箱：</td>
					<td><s:textfield id="userYX" name="userYX" onblur="checkYX()" />
						<span id="pdYX">*</span></td>
				</tr>
				<script type="text/javascript">
					function checkSJ() {
						var re = /^[0-9]{11}$/;
						var userSJ = document.getElementById("userSJ").value;
						var pdSJ = document.getElementById("pdSJ");
						if (re.test(userSJ) == false) {
							pdSJ.innerHTML = "请输入正确的手机号";
							document.getElementById("btnsave").disabled = true;
						} else {
							pdSJ.innerHTML = "<font color='green'>√</font>";
							document.getElementById("btnsave").disabled = false;
						}
					}
				</script>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">手机：</td>
					<td><s:textfield id="userSJ" name="userSJ" onblur="checkSJ()" />
						<span id="pdSJ">* </span></td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="grey">机构信息</td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright" width="120px;">机构代码：</td>
					<td><s:textfield id="userJGDM" name="userJGDM" readonly="true" />
						<span id="pdJGDM">*不可修改 </span></td>
				</tr>
				<script type="text/javascript">
					function checkJGMC() {
						var userJGMC = document.getElementById("userJGMC");
						var pdJGMC = document.getElementById("pdJGMC");
						if (userJGMC.value == "") {
							pdJGMC.innerHTML = "机构名称不能为空";
							document.getElementById("btnsave").disabled = true;
						} else {
							pdJGMC.innerHTML = "<font color='green'>√</font>";
							document.getElementById("btnsave").disabled = false;
						}
					}
				</script>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">机构名称：</td>
					<td><s:textfield id="userJGMC" name="userJGMC"
							onblur="checkJGMC()" /> <span id="pdJGMC">* </span></td>
				</tr>
				<script type="text/javascript">
					function checkYZBM() {
						var re = /^[0-9]{6}$/;// 判定邮政编码
						var userYZBM = document.getElementById("userYZBM").value;
						var pdYZBM = document.getElementById("pdYZBM");
						if (re.test(userYZBM) == false) {
							pdYZBM.innerHTML = "邮政编码输入错误";
							document.getElementById("btnsave").disabled = true;
						} else {
							pdYZBM.innerHTML = "<font color='green'>√</font>";
							document.getElementById("btnsave").disabled = false;
						}
					}
				</script>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">邮政编码：</td>
					<td><s:textfield id="userYZBM" name="userYZBM"
							onblur="checkYZBM()" /> <span id="pdYZBM">* </span></td>
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
	</center>
</body>
</html>