<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<table>
	<tr>
		<td style="height: 50px; width: 120px;">
			<div>
				<span>*</span>科技活动类型
			</div>
		</td>
		<td><s:radio name="reqYJLX" id="reqYJLX"
				style="width:10px; height:10px;"
				list="#{'基础研究':'基础研究','应用研究':'应用研究','试验发展':'试验发展',
				'研究发展与成果应用':'研究发展与成果应用','技术推广与科技服务':'技术推广与科技服务',
				'生产性活动':'生产性活动'}" />
		</td>
	</tr>
	<tr id="q1">
		<td style="height: 50px;">
			<div>
				<span>*</span><span style="font-size: 15px; color: black;">学科分类</span>
			</div>
			<div>
				<span style="font-size: 13px; color: black;">（限基础研究填写）</span>
			</div>
		</td>
		<td>
			<div>
				<select name="reqXKFL" id="reqXKFL1" onchange="changefirst_xk()">
					<option value="${xkflList[0]}">${xkflList[0]}</option>
				</select> <select name="reqXKFL" id="reqXKFL2" onchange="changesecond_xk()"><option
						value="${xkflList[1]}">${xkflList[1]}</option></select> <select name="reqXKFL"
					id="reqXKFL3"><option value="${xkflList[2]}">${xkflList[2]}</option></select>
			</div>
		</td>
	</tr>
	<tr id="w1" style="display: none">
		<td style="height: 80px; width: 120px;">
			<div>
				<span>*</span><span style="font-size: 15px; color: black;">需求技术所属领域</span>
			</div>
			<div>
				<span style="font-size: 13px; color: black;">（非基础研究填写）</span>
			</div>
		</td>
		<td><s:checkboxlist name="reqXQJSSSLY" id="reqXQJSSSLY"
				style="width:10px; height:10px;"
				list="{'电子信息技术','光机电一体化','软件','生物制药技术','新材料及应用技术',
				'先进制造技术','现代农业技术','新能源与高校节能技术','资源与环境保护新技术','其他技术(注明)'}"
				value="%{sslyList}" />&nbsp;&nbsp;&nbsp;（可多选）
			<div id="qtjsms"
				style="display: none; text-align: left; font-size: 14px;">
				其他技术说明：
				<s:textfield type="text" name="reqQTJSMS" id="reqQTJSMS"
					style="width: 650px; border: 1px solid green; height: 15px;" />
			</div></td>
	</tr>
	<tr id="w2" style="display: none">
		<td style="height: 50px;">
			<div>
				<span>*</span><span style="font-size: 15px; color: black;">需求技术应用行业</span>
			</div>
			<div>
				<span style="font-size: 13px; color: black;">（非基础研究填写）</span>
			</div>
		</td>
		<td>
			<div>
				<select name="reqXQJSYYHY" id="reqXQJSYYHY1"
					onchange="changefirst_xq()"><option value="${yyhyList[0]}">${yyhyList[0]}</option></select>
				<select name="reqXQJSYYHY" id="reqXQJSYYHY2"
					onchange="changesecond_xq()"><option value="${yyhyList[1]}">${yyhyList[1]}</option></select>
				<select name="reqXQJSYYHY" id="reqXQJSYYHY3"><option
						value="${yyhyList[2]}">${yyhyList[2]}</option></select>
			</div>
		</td>
	</tr>
</table>