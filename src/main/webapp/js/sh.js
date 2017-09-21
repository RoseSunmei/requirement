$(function() {
	/* **************************************************************页面加载时合作研发 */
	var reqJSXQHZMS = $("input[name=reqJSXQHZMS]");
	if (reqJSXQHZMS[2].checked) {
		$("#hzdw").css('display', 'table-row');
	}
	/* **************************************************************页面加载时基础研究 */
	var reqYJLXS = $("input[name=reqYJLX]");
	if (reqYJLXS[0].checked) {
		$("#q1").css('display', 'table-row');
		$("#w1").css('display', 'none');
		$("#w2").css('display', 'none');
	} else if (reqYJLXS[1].checked || reqYJLXS[2].checked
			|| reqYJLXS[3].checked || reqYJLXS[4].checked
			|| reqYJLXS[5].checked) {
		$("#w1").css('display', 'table-row');
		$("#w2").css('display', 'table-row');
		$("#q1").css('display', 'none');
	}
	var reqXQJSSSLYS = $("input[name=reqXQJSSSLY]");
	if (reqXQJSSSLYS[9].checked) {
		$("#qtjsms").css('display', 'table-row');
	} else {
		$("#qtjsms").css('display', 'none');
	}
})