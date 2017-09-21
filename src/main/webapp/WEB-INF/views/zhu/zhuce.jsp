<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省重大技术需求征集系统</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript" src="/js/zhuce.js"></script>
<!-- 回车换行 -->
<script language="javascript" for="document" event="onkeydown">
	if (event.keyCode == 13 && event.srcElement.type != 'button'
			&& event.srcElement.type != 'submit'
			&& event.srcElement.type != 'reset'
			&& event.srcElement.type != 'textarea'
			&& event.srcElement.type != '')
		event.keyCode = 9; //Tab的键值为9 Enter的键值为13
</script>
<script type="text/javascript">
	
</script>
<style type="text/css">
span {
	color: red;
	font-size: 12px;
}

.grey {
	background-color: SkyBlue;
}

.bgzuo {
	width: 100px;
}

.xx {
	color: red;
	font-size: 12px;
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
	top: 20px;
	right: 50px;
	color: white;
}
</style>
</head>
<body>
	<br />
<%-- 	<s:debug /> --%>
	<s:fielderror />
	<s:form action="register_save" id="zhuceform" name="zhuceform"
		target="_self">
		<table>
			<tr>
				<td class="grey" width="200px;">用户名和密码</td>
				<td class="grey"><font size="1px;" color="red"> <s:fielderror
							fieldName="erroeMsg" /></font></td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">用户名：</td>
				<td><s:textfield id="userName" name="user.userName"
						placeholder="用户名" onblur="checkName()" /> <span id="pdName">*</span></td>
			</tr>

			<tr>
				<td class="bgzuo"></td>
				<td class="tbright">密码：</td>
				<td><s:password id="userPwd" name="user.userPwd"
						placeholder="密码" onblur="checkPwd()" /> <span id="pdPwd">*
				</span></td>

			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright">确认密码：</td>
				<td><s:password id="userPwd1" placeholder="确认密码"
						name="userPwd1" onblur="checkPwd1()" /> <span id="pdPwd1">*
				</span></td>
			</tr>
		</table>
		<!--用户信息 -->
		<table>
			<tr>
				<td class="grey">用户信息</td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright">真实姓名：</td>
				<td><s:textfield id="userZSXM" name="user.userZSXM"
						placeholder="例如:张三" onblur="checkZSXM()" /> <span id="pdZSXM">*</span></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">身份证号：</td>
				<td><s:textfield id="userSFZ" name="user.userSFZ"
						placeholder="例如:513901xxxxxxxxxxxx" onblur="checkSFZ()" /> <span
					id="pdSFZ">*</span></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright">电子邮箱：</td>
				<td><s:textfield id="userYX" name="user。userYX"
						placeholder="例如:123456789@qq.com" onblur="checkYX()" /> <span
					id="pdYX">*</span></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright">手机：</td>
				<td><s:textfield id="userSJ" name="user.userSJ"
						placeholder="例如:12345678910" onblur="checkSJ()" /> <span
					id="pdSJ">* </span></td>
			</tr>
		</table>
		<!--公司信息-->
		<table>
			<tr>
				<td class="grey">机构信息</td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright" width="120px;">机构代码：</td>
				<td><s:textfield id="userJGDM" name="user.userJGDM"
						placeholder="例如:00000001" onblur="checkJGDM()" /> <span
					id="pdJGDM">* </span></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright">机构名称：</td>
				<td><s:textfield id="userJGMC" name="user.userJGMC"
						placeholder="例如:石家庄酒厂" onblur="checkJGMC()" /> <span id="pdJGMC">*
				</span></td>
			</tr>
			<tr>
				<td class="bgzuo"></td>
				<td class="tbright">邮政编码：</td>
				<td><s:textfield id="userYZBM" name="user.userYZBM"
						placeholder="例如:050043" onblur="checkYZBM()" /> <span id="pdYZBM">*
				</span></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="3"><s:submit
						id="btnsave" class="btn" value="注册" onclick="return Check1()" />
					<button class="btn" id="cancelBtn" type="button">取消</button></td>
			</tr>
		</table>
	</s:form>
</body>
</html>