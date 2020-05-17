package com.jp.storage.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jp.storage.dao.EmployeeDAO;
import com.jp.storage.service.EmployeeService;
import com.jp.storage.vo.EmployeeVO;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;
	
	@PostMapping("/employees")
	public void createEmployee(@RequestBody EmployeeVO vo) {
		service.insert(vo);
	}

}
