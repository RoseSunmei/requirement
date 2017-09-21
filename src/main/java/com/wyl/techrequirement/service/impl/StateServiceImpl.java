package com.wyl.techrequirement.service.impl;

import java.util.List;

import com.wyl.techrequirement.domain.State;
import com.wyl.techrequirement.service.IStateService;

public class StateServiceImpl extends BaseServiceImpl<State> implements IStateService {

	@Override
	public List<State> findStateSome() {
		String hql="select o from State o";
		return baseDao.findLimitNum(hql, 2, 4);
	}
}
