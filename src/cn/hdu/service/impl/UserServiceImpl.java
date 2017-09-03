package cn.hdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.exception.DaoException;
import cn.hdu.mapper.UserMapper;
import cn.hdu.po.Doctor;
import cn.hdu.po.DoctorVo;
import cn.hdu.po.Patient;
import cn.hdu.po.PatientVo;
import cn.hdu.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	@Override
	public void doctorRegister(Doctor doctor) throws DaoException {

		userMapper.doctorRegister(doctor);
	}

	@Override
	public void patientRegister(Patient patient) throws DaoException {
		
		userMapper.patientRegister(patient);
	}

	@Override
	public Doctor doctorLogin(DoctorVo doctorVo)  throws DaoException{
		Doctor doctor = userMapper.doctorLogin(doctorVo);
		if(doctor!=null){
			return doctor;
		}
		return null;
	}

	@Override
	public Patient patientLogin(PatientVo patientVo) throws DaoException{
		Patient patient = userMapper.patientLogin(patientVo);
		if(patient!=null){
			return patient;
		}
		return null;
	}

	@Override
	public void updatePatient(Patient patient) throws DaoException {
		userMapper.updatePatient(patient);
		
	}

	@Override
	public Patient findPatientById(String id) throws DaoException {
		Patient patient = userMapper.findPatientById(id);
		if(patient!=null){
			return patient;
		}
		return null;
	}

	@Override
	public void updateDoctor(Doctor doctor) throws DaoException {
		 userMapper.updateDoctor(doctor);
	}

	@Override
	public Doctor findDoctorById(String id) throws DaoException {
		Doctor doctor = userMapper.findDoctorById(id);
		if(doctor!=null){
			return doctor;
		}
		return null;
	}

}
