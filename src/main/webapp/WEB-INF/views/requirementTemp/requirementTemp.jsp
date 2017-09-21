</table><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table>
	<tr>
		<td style="width: 120px;">
			<div>
				<span>*&nbsp;</span>机构全称
			</div>
		</td>
		<font size="2px;"></font>
		<td style="width: 40%;"><font size="2px;">${user.userJGMC}</font></td>
		<td style="width: 120px;">
			<div>归口管理部门</div>
		</td>
		<td><font size="2px;">${putunder.putName }</font></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>通讯地址
			</div>
		</td>
		<td><font size="2px;">${reqTXDZ }</font></td>
		<td>
			<div>
				<span>*&nbsp;</span>所在地域
			</div>
		</td>
		<td><font size="2px;">${area.areaName }</font></td>
	</tr>
	<tr>
		<td>
			<div>单位网址</div>
		</td>
		<td><font size="2px;">${reqDWWZ }</font></td>
		<td>
			<div>
				<span>*&nbsp;</span>电子信箱
			</div>
		</td>
		<td><font size="2px;">${reqDZYX }</font></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>法人代表
			</div>
		</td>
		<td><font size="2px;">${reqFRDB }</font></td>
		<td>
			<div>邮政编码</div>
		</td>
		<td><font size="2px;">${reqYZBM }</font></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>联系人
			</div>
		</td>
		<td><font size="2px;">${reqLXR }</font></td>
		<td>
			<div>固定电话</div>
		</td>
		<td><font size="2px;">${reqGDDH }</font></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>手 机
			</div>
		</td>
		<td><font size="2px;">${reqYDDH }</font></td>
		<td>
			<div>传 真</div>
		</td>
		<td><font size="2px;">${reqCZ }</font></td>
	</tr>
	<tr>
		<td style="height: 40px;">
			<div>
				<span>*&nbsp;</span>机构属性
			</div>
		</td>
		<td colspan="3"><s:radio name="reqJGSX" id="reqJGSX" disabled="true"
				style="width:10px; height:10px;"
				list="#{'企业':'企业','高等院校':'高等院校','研究机构':'研究机构','其它':'其它'}" /></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>机构简介
			</div>
		</td>
		<td colspan="3"><font size="2px;">${reqJGJJ }</font></td>
	</tr>
</table>
<%-- <%@include file="/WEB-INF/views/requirement/requirement_top.jsp"%> --%>
<table>
	<tr>
		<td style="height: 40px; width: 120px;"><span>*&nbsp;</span>技术需求名称
		</td>
		<td style="width: 45%;"><font size="2px;">${reqJSXQMC }</font></td>
		<td style="width: 100px;">
			<div>
				<span>*&nbsp;</span>需求时限
			</div>
		</td>
		<td><font size="2px;">${reqQSXQNF }</font>年至<font size="2px;">${reqJZXQNF }</font>年</td>
	</tr>
	<tr>
		<td rowspan="3"><span>*&nbsp;</span>技术需求概述</td>
		<td colspan="3"><font size="2px;">1、主要问题：${reqJSXQGS}</font></td>
	</tr>
	<tr>
		<td colspan="3"><font size="2px;">2、技术关键：${reqJSXQGS1 }</font></td>
	</tr>
	<tr>
		<td colspan="3"><font size="2px;">3、预期目标：${reqJSXQGS2 }</font></td>
	</tr>
</table>
<table>
	<tr>
		<td style="width: 120px;">
			<div>
				<span>*&nbsp;</span>关键字:
			</div>
		</td>
		<td colspan="3"><font size="2px;">${reqGJZ }</font></td>
	</tr>
	<tr>
		<td style="height: 40px;">
			<div>拟投入资金总额</div>
		</td>
		<td><font size="2px;">${reqJHZTZ }</font>万元</td>
	</tr>
	<tr>
		<td rowspan="2" style="height: 40px;">
			<div>
				<span>*&nbsp;</span>技术需求解决方式
			</div>
		</td>
		<td><s:radio name="reqJSXQHZMS" style="width:10px; height:10px;" disabled="true"
				list="#{'独立研发':'独立研发','委托研发':'委托研发 ','合作研发':'合作研发','其它':'其它'}" /></td>
	</tr>
	<tr id="hzdw" style="display: none;">
		<td style="height: 20px;">&nbsp;合作意向单位：<font size="2px;">${reqHZYXDW }</font></td>
	</tr>
</table>
<%-- <%@include file="/WEB-INF/views/requirement/requirement_middle.jsp"%> --%>
<table>
	<tr>
		<td style="height: 50px; width: 120px;">
			<div>
				<span>*</span>科技活动类型
			</div>
		</td>
		<td><s:radio name="reqYJLX" id="reqYJLX"
				style="width:10px; height:10px;" disabled="true"
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
		<td><font size="2px;">${reqXKFL }</font></td>
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
				style="width:10px; height:10px;" disabled="true"
				list="{'电子信息技术','光机电一体化','软件','生物制药技术','新材料及应用技术',
				'先进制造技术','现代农业技术','新能源与高校节能技术','资源与环境保护新技术','其他技术(注明)'}"
				value="%{sslyList}" />
			<div id="qtjsms"
				style="display: none; text-align: left; font-size: 14px;">
				其他技术说明：
				${reqQTJSMS }
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
		<td><font size="2px;">${reqXQJSYYHY }</font></td>
	</tr>
</table>
