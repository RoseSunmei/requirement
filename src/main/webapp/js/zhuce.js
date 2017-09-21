var xhr;
// 统一获取XMLHttpRequest的方法
function createXhr() {
	try {
		xhr = new XMLHttpRequest();
	} catch (e) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function checkName() {
	var reg = /^[0-9a-zA-Z]+$/; // 数字和字母
	var userName = document.getElementById("userName").value;
	var pdName = document.getElementById("pdName");
	// 1.创建ajax对象
	createXhr();
	// 2.调用open方法，没有返回值
	// 获取用户输入的注册的用户名
	var userName = document.getElementById("userName").value;
	xhr.open("GET", "/register_checkName.action?userName=" + userName + "&"
			+ new Date().getTime(), true);
	// 3.监控readyState是否发生改变
	// 存储函数（或函数名），每当 readyState 属性改变时，就会调用该函数。
	xhr.onreadystatechange = function() {// 匿名函数
		// console.debug(xhr.readyState);
		// ajax请求已经响应完成并且响应状态是200
		if (xhr.readyState == 4 && xhr.status == 200) {
			// 获取ajax请求返回的内容
			var text = xhr.responseText;
			// 后台传入的布尔值，但是前台js接受的是字符串
			// console.debug(text.length);
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
	// 4.发出请求
	// string：仅用于 POST 请求，字符串必须服务器URL编码格式（列如：param1=value1&param2=value2）;
	// user.id=&user.name=454544&user.amount=4444
	// 提交默认的编码格式：enctype=application/x-www-form-urlencoded
	xhr.send();
}
function checkPwd() {
	var userPwd = document.getElementById("userPwd");
	var pdPwd = document.getElementById("pdPwd");
	if (userPwd.value.length > 18 || userPwd.value.length < 6) {
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
	if (userPwd.value != userPwd1.value || userPwd1.value == "") {
		pdPwd1.innerHTML = "两次输入的密码不相同";
		document.getElementById("btnsave").disabled = true;
	} else {
		pdPwd1.innerHTML = "<font color='green'>√</font>";
		document.getElementById("btnsave").disabled = false;
	}
}
function checkZSXM() {
	var userZSXM = document.getElementById("userZSXM");
	var pdZSXM = document.getElementById("pdZSXM");
	if (userZSXM.value == "") {
		pdZSXM.innerHTML = "真实姓名不能为空";
		document.getElementById("btnsave").disabled = true;
	} else {
		pdZSXM.innerHTML = "<font color='green'>√</font>";
		document.getElementById("btnsave").disabled = false;
	}
}
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
function checkJGDM() {
	var userJGDM = document.getElementById("userJGDM");
	var pdJGDM = document.getElementById("pdJGDM");
	if (userJGDM.value == "") {
		pdJGDM.innerHTML = "机构代码不能为空";
		document.getElementById("btnsave").disabled = true;
	} else {
		pdJGDM.innerHTML = "<font color='green'>√</font>";
		document.getElementById("btnsave").disabled = false;
	}
}
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
function Check1() {
	var reg = /^[0-9a-zA-Z]+$/; // 数字和字母
	var userName = document.getElementById("userName").value;
	var pdName = document.getElementById("pdName");
	if (userName.length > 20 || userName.length < 6 || !reg.test(userName)) {
		alert("用户名只能由6-20个数字和英文字母组成");
		return false;
	} else {
		document.getElementById("user_inputForm").submit();
	}
}