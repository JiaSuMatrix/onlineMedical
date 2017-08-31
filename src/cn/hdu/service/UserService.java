package cn.hdu.service;

import cn.hdu.po.Doctor;
import cn.hdu.po.Patient;

public interface UserService {

	void doctor_register(Doctor doctor);

	void patient_register(Patient patient);

}
