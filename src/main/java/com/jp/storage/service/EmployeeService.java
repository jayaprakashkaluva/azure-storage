package com.jp.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.storage.dao.EmployeeDAO;
import com.jp.storage.vo.EmployeeVO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	public void insert(EmployeeVO vo) {
		dao.insert(vo);
	}
}
