package cn.hdu.service;

import java.util.List;

import cn.hdu.po.Hospital;

public interface HospitalService {

	// 查出所有医院
	List<Hospital> findAllHospital() throws Exception;

	// 根据姓名查找医医院
	Hospital findHospitalByName(String hospitalName) throws Exception;

	// 根据id查找医院
	Hospital findHospitalById(String id) throws Exception;
	
}
