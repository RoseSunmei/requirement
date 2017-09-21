package com.wyl.techrequirement.web.action;

public class MainAction extends BaseAction {

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String left() throws Exception {
		return "left";
	}
	
	public String right() throws Exception {
		return "right";
	}
	
}
