package com.sam.app.insa.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentsVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;

}
