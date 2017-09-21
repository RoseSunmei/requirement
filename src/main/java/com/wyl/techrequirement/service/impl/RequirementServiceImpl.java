package com.wyl.techrequirement.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.wyl.techrequirement.domain.Requirement;
import com.wyl.techrequirement.service.IRequirementService;

public class RequirementServiceImpl extends BaseServiceImpl<Requirement> implements IRequirementService {

	@Override
	public String findReqNum() {
		String reqNum = "";
		String hql = "select count(o) from Requirement o ";
		Integer tempNum = baseDao.findTotalNum(hql);
		tempNum++;
		if (tempNum < 10) {
			reqNum = "000" + tempNum;
		} else if (tempNum < 100) {
			reqNum = "00" + tempNum;
		} else if (tempNum < 1000) {
			reqNum = "0" + tempNum;
		}
		String tempDate = new SimpleDateFormat("yyyyMMddhh").format(Calendar.getInstance().getTime());
		return tempDate + reqNum;
	}
}
