package com.sam.app.insa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sam.app.insa.service.DepartmentsService;
import com.sam.app.insa.service.DepartmentsVO;

@Controller
public class DepartmentsController {

	@Autowired
	DepartmentsService departmentsservice;

	// 전체조회.
	//url
	@GetMapping("/departmentsList")
	public String getdepartmentsList(DepartmentsVO vo, Model model) {
		model.addAttribute("departments", departmentsservice.getdepartmentsList());
		return "insa/departmentsList";
	}
}
