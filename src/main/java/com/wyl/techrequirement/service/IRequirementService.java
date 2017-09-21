package com.wyl.techrequirement.service;

import com.wyl.techrequirement.domain.Requirement;

public interface IRequirementService extends IBaseService<Requirement>{

	String findReqNum();
}
