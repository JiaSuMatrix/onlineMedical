package cn.hdu.mapper;

import cn.hdu.exception.DaoException;
import cn.hdu.po.Doctor;
import cn.hdu.po.DoctorVo;
import cn.hdu.po.Patient;
import cn.hdu.po.PatientVo;

public interface UserMapper {

	void doctorRegister(Doctor doctor) throws DaoException;

	void patientRegister(Patient patient) throws DaoException;

	Doctor doctorLogin(DoctorVo doctorVo) throws DaoException;

	Patient patientLogin(PatientVo patientVo) throws DaoException;

	void updatePatient(Patient patient) throws DaoException;

	Patient findPatientById(String id) throws DaoException;

	void updateDoctor(Doctor doctor) throws DaoException;

	Doctor findDoctorById(String id)  throws DaoException;

}
