package cn.hdu.service;

import java.util.List;

import cn.hdu.exception.DaoException;
import cn.hdu.po.Department;

public interface DepartmentService {

	// 根据医院id查出该医院所有的科室
	List<Department> findAllDepartmentByhospitalId(String hospitalId) throws DaoException;

}