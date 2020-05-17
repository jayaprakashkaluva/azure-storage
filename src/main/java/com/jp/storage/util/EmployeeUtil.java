package com.jp.storage.util;

import org.springframework.beans.BeanUtils;

import com.jp.storage.entity.Employee;
import com.jp.storage.vo.EmployeeVO;

public class EmployeeUtil {

	public static Employee toEntity(EmployeeVO vo) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(vo, employee);
		return employee;
	}
}
