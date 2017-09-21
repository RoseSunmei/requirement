<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<table>
	<tr>
		<td style="width: 120px;">
			<div>
				<span>*&nbsp;</span>机构全称
			</div>
		</td>
		<td style="width: 40%;"><s:textfield name="reqJGMC" value="%{user.userJGMC}"
				readonly="true" /></td>
		<td style="width: 120px;">
			<div>归口管理部门</div>
		</td>
		<td><s:select list="#allPuts" name="putunder.putId" id="putunder"
				listValue="putName" listKey="putId" headerKey="-1"
				headerValue="-----------------请选择-----------------" /></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>通讯地址
			</div>
		</td>
		<td><s:textfield name="reqTXDZ" id="reqTXDZ"
				placeholder="例如:石家庄北二环东路17号" /></td>
		<td>
			<div>
				<span>*&nbsp;</span>所在地域
			</div>
		</td>
		<td><s:select list="#allAreas" name="area.areaId" id="area"
				listValue="areaName" listKey="areaId" headerKey="-1"
				headerValue="-----------------请选择-----------------" /></td>
		<%-- 		<td><s:textfield name="area.areaName" id="area_id" --%>
		<%-- 				placeholder="输入地域编号" /></td> --%>
	</tr>
	<tr>
		<td>
			<div>单位网址</div>
		</td>
		<td><s:textfield name="reqDWWZ" id="reqDWWZ"
				placeholder="例如:http(s)://www.stdu.edu.cn/" style="width: 99.5%"
				onblur="reqWZ()" /></td>
		<td>
			<div>
				<span>*&nbsp;</span>电子信箱
			</div>
		</td>
		<td><s:textfield name="reqDZYX" id="reqDZYX"
				placeholder="例如:123456@qq.com" onblur="reqYX()" /></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>法人代表
			</div>
		</td>
		<td><s:textfield name="reqFRDB" id="reqFRDB" placeholder="例如:张三" /></td>
		<td>
			<div>邮政编码</div>
		</td>
		<td><s:textfield name="reqYZBM" value="%{user.userYZBM}" readonly="true" /></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>联系人
			</div>
		</td>
		<td><s:textfield name="reqLXR" id="reqLXR" placeholder="例如:李四" /></td>
		<td>
			<div>固定电话</div>
		</td>
		<td><s:textfield name="reqGDDH" id="reqGDDH"
				placeholder="例如:0311-1234567" /></td>
	</tr>
	<tr>
		<td>
			<div>
				<span>*&nbsp;</span>手 机
			</div>
		</td>
		<td><s:textfield name="reqYDDH" id="reqYDDH"
				placeholder="例如:12345678910" onblur="reqSJ()" /></td>
		<td>
			<div>传 真</div>
		</td>
		<td><s:textfield name="reqCZ" id="reqCZ" placeholder="传真" /></td>
	</tr>
	<tr>
		<td style="height: 40px;">
			<div>
				<span>*&nbsp;</span>机构属性
			</div>
		</td>
		<td colspan="3"><s:radio name="reqJGSX" id="reqJGSX"
				style="width:10px; height:10px;"
				list="#{'企业':'企业','高等院校':'高等院校','研究机构':'研究机构','其它':'其它'}" /></td>
	</tr>
	<tr>
		<td colspan="4" style="border-bottom: none;"><span>&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;</span>
			机构简介（主要包括基本情况、现有研究基础等，限500字以内） <span id="jgjjNum">0</span><span
			style="color: black">/500</span><br /> <s:textarea name="reqJGJJ"
				id="reqJGJJ" onkeyup="showJGJJ()" rows="5" cols="107" placeholder="例如:xxx公司/企业/机构成立于xxxx年"/></td>
	</tr>
</table>