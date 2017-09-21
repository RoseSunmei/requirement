package com.wyl.techrequirement.service;

import java.util.List;

import com.wyl.techrequirement.domain.State;

public interface IStateService extends IBaseService<State> {
	List<State> findStateSome();
}
