package cn.hdu.mapper;

import java.util.List;

import cn.hdu.exception.DaoException;
import cn.hdu.po.Department;
import cn.hdu.po.Doctor;
import cn.hdu.po.DoctorVo;
import cn.hdu.po.Hospital;
import cn.hdu.po.Patient;
import cn.hdu.po.PatientVo;

public interface UserMapper {

	// 医生注册
	void doctorRegister(Doctor doctor) throws DaoException;

	// 患者注册
	void patientRegister(Patient patient) throws DaoException;

	// 医生登录
	Doctor doctorLogin(DoctorVo doctorVo) throws DaoException;

	// 患者登录
	Patient patientLogin(PatientVo patientVo) throws DaoException;

	// 更新患者信息
	void updatePatient(Patient patient) throws DaoException;

	// 根据id查找患者
	Patient findPatientById(String id) throws DaoException;

	// 更新医生信息
	void updateDoctor(Doctor doctor) throws DaoException;

	// 根据id查找医生
	Doctor findDoctorById(String id) throws DaoException;

	//查出所有医院
	List<Hospital> findAllHospital() throws DaoException;

	//根据医院id查出该医院所有的科室
	List<Department> findAllDepartmentByhospitalId(String hospitalId) throws DaoException;

	//根据姓名查找医生
	Hospital findHospitalByName(String hospitalName) throws DaoException;
}
