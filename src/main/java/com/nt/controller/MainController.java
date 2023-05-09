package com.nt.controller;

import org.springframework.stereotype.Component;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;
//@Component("controller")
public class MainController {
private IEmployeeMgmtService service;

public MainController(IEmployeeMgmtService service) {
	System.out.println("MainController:1-param constructor");
	this.service = service;
}
public String processEmployee(EmployeeVO vo)throws Exception {
	EmployeeDTO dto=new EmployeeDTO();
	dto.setEname(vo.getEname());
	dto.setDesg(vo.getDesg());
	dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
	String result=service.registerEmployee(dto);
	return result;
}

}
