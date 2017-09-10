package cn.hdu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.exception.DaoException;
import cn.hdu.mapper.DepartmentMapper;
import cn.hdu.po.Department;
import cn.hdu.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	@Qualifier("departmentMapper")
	private DepartmentMapper departmentMapper;

	//根据医院id查出该医院所有的科室
	@Override
	public List<Department> findAllDepartmentByhospitalId(String hospitalId) throws DaoException {
		List<Department> departments = departmentMapper.findAllDepartmentByhospitalId(hospitalId);
		if(departments != null){
			return departments;
		}
		return null;
	}

}
