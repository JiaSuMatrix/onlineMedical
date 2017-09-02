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

}
