package cn.hdu.service;

import java.util.List;

import cn.hdu.exception.DaoException;
import cn.hdu.po.Hospital;

public interface HospitalService {

	// 查出所有医院
	List<Hospital> findAllHospital() throws DaoException;

	// 根据姓名查找医医院
	Hospital findHospitalByName(String hospitalName) throws DaoException;
}
