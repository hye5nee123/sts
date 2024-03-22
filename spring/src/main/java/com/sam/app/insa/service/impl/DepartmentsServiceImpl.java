package com.sam.app.insa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.app.insa.mapper.DepartmentMapper;
import com.sam.app.insa.service.DepartmentsService;
import com.sam.app.insa.service.DepartmentsVO;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
	@Autowired
	DepartmentMapper departmentmapper;

	@Override
	public List<DepartmentsVO> getdepartmentsList() {
		return departmentmapper.getdepartmentsList();
	}
}
