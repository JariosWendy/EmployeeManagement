package com.wwwxy.employeemanagement.control;

import java.util.List;

import com.wwwxy.employeemanagement.dao.SalaryDao;
import com.wwwxy.employeemanagement.entity.SalaryEntity;

public class SalaryControl {
	SalaryDao sd =new SalaryDao();
	
	
	
	//��ѯ����
	public List<SalaryEntity> GetAllSalary() {
		return sd.GetAllSalary();
	}
	//��ѯĳ��Ա����Ϣ��ʹ��Ա��ID��ѯ
	public List<SalaryEntity> GetSalaryById(int id) {
		return sd.GetSalaryById(id);
	}
	
	
}
