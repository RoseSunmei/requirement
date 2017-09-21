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
	width: 90px;
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
	right: 50px;
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
		var ids = $("input[name=ids]");
		if (ids[1].checked) {
			if ($("#xzdept option:selected").val() == -1) {
				alert("请选择部门审核员所属部门");
				return false;
			}
		}
		var flag = 0;
		for (var i = 0; i < ids.length; i++) {
			if (ids[i].checked) {
				flag = 1;
			}
		}
		if (flag == 0) {
			alert("请选择用户的角色");
			return false;
		}
		if (userName.length > 20 || userName.length < 6 || !reg.test(userName)) {
			alert("用户名只能由6-20个数字和英文字母组成");
			return false;
		}
		if ($("#userPwd").val() == "") {
			alert("请输入密码");
			return false;
		}
		if ($("#userPwd1").val() != $("#userPwd").val()) {
			alert("两次输入的密码必须相等");
			return false;
		} else {
			document.getElementById("user_inputForm").submit();
		}

	}
	$(function() {
		if ($("input[name=ids]")[1].checked) {
			$("#depts").css('display', 'table-row');
		} else {
			$("#depts").css('display', 'none');
		}
		$("input[name=ids]").click(function() {
			var ids = $("input[name=ids]");
			if (ids[1].checked) {
				$("#depts").css('display', 'table-row');
			} else {
				$("#depts").css('display', 'none');
			}
		})
	})
</script>
<body>
	<br />
	<%-- 	<s:debug /> --%>
	<%-- 	<s:textfield name="roles" /> --%>
	<s:form action="user_save" id="user_inputForm">
		<s:hidden id="userId" name="userId" />
		<s:hidden name="baseQuery.currentPage" />
		<s:hidden name="baseQuery.pageSize" />
		<s:hidden name="baseQuery.userName" />
		<s:hidden name="baseQuery.usreJGMC" />
		<s:hidden name="baseQuery.deptId" />
		<table>
			<tr>
				<td class="grey" width="180px;">角色和部门</td>
				<td class="grey"><font color="red" size="1px;"><s:fielderror /></font></td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">角色：</td>
				<td><s:checkboxlist style="width:10px;" list="#allRoles"
						name="ids" listValue="roleName" listKey="roleId" /></td>
			</tr>
		</table>
		<table>
			<tr id="depts" style="display: none;">
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">部门：</td>
				<td><s:select style="width:205px; height:23px;" id="xzdept"
						list="#allDepts" name="department.deptId" listValue="deptName"
						listKey="deptId" headerKey="-1"
						headerValue="--------------请选择------------------" /> <span>*</span></td>
			</tr>
		</table>
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
				//1.创建ajax对象
				createXhr();
				//2.调用open方法，没有返回值
				//获取用户输入的注册的用户名
				var userId = document.getElementById("userId").value;
				xhr.open("GET", "/user_checkName.action?userId=" + userId
						+ "&userName=" + userName + "&" + new Date().getTime(),
						true);
				//3.监控readyState是否发生改变
				//存储函数（或函数名），每当 readyState 属性改变时，就会调用该函数。
				xhr.onreadystatechange = function() {//匿名函数
					// 			console.debug(xhr.readyState);
					//ajax请求已经响应完成并且响应状态是200			
					if (xhr.readyState == 4 && xhr.status == 200) {
						//获取ajax请求返回的内容
						var text = xhr.responseText;
						//alert(text);
						//后台传入的布尔值，但是前台js接受的是字符串
						// 				console.debug(text.length);
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
				// 	4.发出请求
				//string：仅用于 POST 请求，字符串必须服务器URL编码格式（列如：param1=value1&param2=value2）;
				//user.id=&user.name=454544&user.amount=4444
				//提交默认的编码格式：enctype=application/x-www-form-urlencoded
				xhr.send();
				// 		alert(0);	
			}
		</script>
		<table>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">用户名：</td>
				<td><s:textfield id="userName" name="userName"
						placeholder="用户名" onblur="checkName()" /> <span id="pdName">*</span></td>
			</tr>

			<s:if test="userId==null">
				<script type="text/javascript">
					function checkPwd() {
						var userPwd = document.getElementById("userPwd");
						var pdPwd = document.getElementById("pdPwd");
						if (userPwd.value.length > 18
								|| userPwd.value.length < 6) {
							pdPwd.innerHTML = "请输入6-18位密码";
							document.getElementById("btnsave").disabled = true;
						} else {
							pdPwd.innerHTML = "<font color='green'>√</font>";
							document.getElementById("btnsave").disabled = false;
						}
					}
					function checkPwd1() {
						var userPwd = document.getElementById("userPwd");
						var userPwd1 = document.getElementById("userPwd1");
						var pdPwd1 = document.getElementById("pdPwd1");
						if (userPwd.value != userPwd1.value
								|| userPwd1.value == "") {
							pdPwd1.innerHTML = "两次输入的密码不相同";
							document.getElementById("btnsave").disabled = true;
						} else {
							pdPwd1.innerHTML = "<font color='green'>√</font>";
							document.getElementById("btnsave").disabled = false;
						}
					}
				</script>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">密码：</td>
					<td><s:password id="userPwd" showPassword="true"
							placeholder="密码" name="userPwd" onblur="checkPwd()" /> <span
						id="pdPwd">* </span></td>

				</tr>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">确认密码：</td>
					<td><s:password id="userPwd1" showPassword="true"
							placeholder="确认密码" name="userPwd1" onblur="checkPwd1()" /> <span
						id="pdPwd1">* </span></td>
				</tr>
			</s:if>
		</table>
		<s:if test="userId!=null">
			<table>
				<tr>
					<td class="grey">用户信息</td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">真实姓名：</td>
					<td><s:textfield id="userZSXM" name="userZSXM"
							placeholder="例如:张三" onblur="checkZSXM()" /> <span id="pdZSXM">*</span></td>
				</tr>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright" width="120px;">身份证号：</td>
					<td><s:textfield id="userSFZ" name="userSFZ"
							placeholder="例如:513901xxxxxxxxxxxx" onblur="checkSFZ()" /> <span
						id="pdSFZ">*</span></td>
				</tr>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">电子邮箱：</td>
					<td><s:textfield id="userYX" name="userYX"
							placeholder="例如:123456789@qq.com" onblur="checkYX()" /> <span
						id="pdYX">*</span></td>
				</tr>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">手机：</td>
					<td><s:textfield id="userSJ" name="userSJ"
							placeholder="例如:12345678910" onblur="checkSJ()" /> <span
						id="pdSJ">* </span></td>
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
					<td><s:textfield id="userJGDM" name="userJGDM"
							placeholder="例如:00000001" onblur="checkJGDM()" /> <span
						id="pdJGDM">* </span></td>
				</tr>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">机构名称：</td>
					<td><s:textfield id="userJGMC" name="userJGMC"
							placeholder="例如:石家庄酒厂" onblur="checkJGMC()" /> <span id="pdJGMC">*
					</span></td>
				</tr>
				<tr>
					<td class="bgzuo"></td>
					<td class="tbright">邮政编码：</td>
					<td><s:textfield id="userYZBM" name="userYZBM"
							placeholder="例如:050043" onblur="checkYZBM()" /> <span
						id="pdYZBM">* </span></td>
				</tr>
			</table>
		</s:if>
		<table>
			<tr>
				<td style="text-align: center;" colspan="3"><s:submit
						id="btnsave" class="btn" value="保存" onclick="return Check1()" />&nbsp;&nbsp;
					<button class="btn" id="cancelBtn" type="button">取消</button></td>
			</tr>
		</table>
	</s:form>
</body>
</html>