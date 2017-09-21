<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<table>
	<tr>
		<td style="height: 40px; width: 120px;"><span>*&nbsp;</span>技术需求名称
		</td>
		<td style="width: 45%;"><s:textfield name="reqJSXQMC"
				id="reqJSXQMC" placeholder="例如:xxx技术" /></td>
		<td style="width: 100px;">
			<div>
				<span>*&nbsp;</span>需求时限
			</div>
		</td>
		<td><s:textfield name="reqQSXQNF" id="reqQSXQNF"
				style="width:35%" placeholder="例如:2017" />年至 <s:textfield
				name="reqJZXQNF" id="reqJZXQNF" style="width:35%"
				placeholder="例如:2020" />年</td>
	</tr>
	<tr>
		<td colspan="4"><span>*&nbsp;</span>技术需求概述<br />
			1、主要问题（需要解决的重大技术问题，限500字以内）<span id="jsxqgsNum">0</span><span
			style="color: black">/500</span> <s:textarea onkeyup="showJSXQGS()"
				cols="107" rows="5" id="reqJSXQGS" name="reqJSXQGS" /></td>
	</tr>
	<tr>
		<td colspan="4">2、技术关键（所需的关键技术、主要指标，限500字以内）<span id="jsxqgs1Num">0</span><span
			style="color: black">/500</span> <s:textarea onkeyup="showJSXQGS1()"
				cols="107" rows="5" id="reqJSXQGS1" name="reqJSXQGS1" />
		</td>
	</tr>
	<tr>
		<td colspan="4">3、预期目标（技术创新性、经济社会效益，限500字以内）<span id="jsxqgs2Num">0</span><span
			style="color: black">/500</span> <s:textarea onkeyup="showJSXQGS2()"
				cols="107" rows="5" id="reqJSXQGS2" name="reqJSXQGS2" />
		</td>
	</tr>
</table>
<table>
	<tr>
		<td style="width: 120px; height: 50px;">
			<div>
				<span>*&nbsp;</span>关键字(1-5个):
			</div>
		</td>
		<td colspan="4" style="border-top: none; height: 45px;">
			<s:textfield name="reqGJZ" id="reqGJZ1" class="gjz" onblur="key1()" value="%{gjzList[0]}" /> 
			<s:textfield name="reqGJZ" id="reqGJZ2" class="gjz1" readonly="readonly" onblur="key2()" value="%{gjzList[1]}" /> 
			<s:textfield name="reqGJZ" id="reqGJZ3" class="gjz1" readonly="readonly" onblur="key3()" value="%{gjzList[2]}" /> 
			<s:textfield name="reqGJZ" id="reqGJZ4" class="gjz1" readonly="readonly" onblur="key4()" value="%{gjzList[3]}" /> 
			<s:textfield name="reqGJZ" id="reqGJZ5" class="gjz1" readonly="readonly" value="%{gjzList[4]}" /></td>
	</tr>
	<tr>
		<td style="height: 40px;">
			<div>拟投入资金总额</div>
		</td>
		<td><s:textfield name="reqJHZTZ" id="reqJHZTZ" style="width:83%"
				placeholder="例如:100.55" />万元</td>
	</tr>
	<tr>
		<td rowspan="2" style="height: 40px;">
			<div>
				<span>*&nbsp;</span>技术需求解决方式
			</div>
		</td>
		<td><s:radio name="reqJSXQHZMS" style="width:10px; height:10px;"
				list="#{'独立研发':'独立研发','委托研发':'委托研发 ','合作研发':'合作研发','其它':'其它'}" /></td>
	</tr>
	<tr id="hzdw" style="display: none;">
		<td style="height: 20px;">&nbsp;合作意向单位：<s:textfield
				name="reqHZYXDW" id="reqHZYXDW" style="width:70%; height:30px;" />（选填）
		</td>
	</tr>
</table>