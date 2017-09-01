package cn.hdu.mapper;

import cn.hdu.po.Doctor;
import cn.hdu.po.DoctorVo;
import cn.hdu.po.Patient;
import cn.hdu.po.PatientVo;

public interface UserMapper {

	void doctorRegister(Doctor doctor);

	void patientRegister(Patient patient);

	Doctor doctorLogin(DoctorVo doctorVo);

	Patient patientLogin(PatientVo patientVo);

}
