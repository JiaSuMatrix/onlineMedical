package cn.hdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.mapper.UserMapper;
import cn.hdu.po.Doctor;
import cn.hdu.po.Patient;
import cn.hdu.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	@Override
	public void doctor_register(Doctor doctor) {

		userMapper.doctor_register(doctor);
	}

	@Override
	public void patient_register(Patient patient) {
		
		userMapper.patient_register(patient);
	}
}
