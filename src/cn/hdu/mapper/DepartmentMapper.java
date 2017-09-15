package cn.hdu.mapper;

import java.util.List;

import cn.hdu.po.Department;
import cn.hdu.po.DepartmentVo;

public interface DepartmentMapper {

	// 根据医院id查出该医院所有的科室
	List<Department> findAllDepartmentByhospitalId(String hospitalId) throws Exception;

	//根据医院ID和科室名称查找特定科室
	Department findDepartmentByhospitalIdAndName(DepartmentVo departmentVo) throws Exception;

}
