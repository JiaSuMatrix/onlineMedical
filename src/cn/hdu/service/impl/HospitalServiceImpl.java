package cn.hdu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.mapper.HospitalMapper;
import cn.hdu.po.Hospital;
import cn.hdu.service.HospitalService;

public class HospitalServiceImpl implements HospitalService {

	@Autowired
	@Qualifier("hospitalMapper")
	private HospitalMapper hospitalMapper;

	// 查出所有医院
	@Override
	public List<Hospital> findAllHospital() throws Exception {
		List<Hospital> hospitals = hospitalMapper.findAllHospital();
		if (hospitals != null) {
			return hospitals;
		}
		return null;
	}

	// 根据姓名查找医院
	@Override
	public Hospital findHospitalByName(String hospitalName) throws Exception {
		Hospital hospital = hospitalMapper.findHospitalByName(hospitalName);
		if (hospital != null) {
			return hospital;
		}
		return null;
	}

}
