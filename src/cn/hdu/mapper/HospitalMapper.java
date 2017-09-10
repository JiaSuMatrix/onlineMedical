package cn.hdu.mapper;

import java.util.List;

import cn.hdu.exception.DaoException;
import cn.hdu.po.Hospital;

public interface HospitalMapper {

	// 查出所有医院
	List<Hospital> findAllHospital() throws DaoException;

	// 根据姓名查找医院
	Hospital findHospitalByName(String hospitalName) throws DaoException;
}
