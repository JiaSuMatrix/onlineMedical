package cn.hdu.mapper;

import cn.hdu.po.Doctor;
import cn.hdu.po.Patient;

public interface UserMapper {

	void doctor_register(Doctor doctor);

	void patient_register(Patient patient);

}
