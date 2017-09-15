package cn.hdu.service;

import cn.hdu.po.Doctor;
import cn.hdu.po.DoctorVo;
import cn.hdu.po.Patient;
import cn.hdu.po.PatientVo;

public interface UserService {

	// 医生注册
	void doctorRegister(Doctor doctor) throws Exception;

	// 患者注册
	void patientRegister(Patient patient) throws Exception;

	// 医生登录
	Doctor doctorLogin(DoctorVo doctorVo) throws Exception;

	// 患者登录
	Patient patientLogin(PatientVo patientVo) throws Exception;

	// 更新患者信息
	void updatePatient(Patient patient) throws Exception;

	// 根据id查找患者
	Patient findPatientById(String id) throws Exception;

	// 更新医生信息
	void updateDoctor(Doctor doctor) throws Exception;

	// 根据id查找医生
	Doctor findDoctorById(String id) throws Exception;

}
