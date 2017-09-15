package cn.hdu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.hdu.exception.CustomException;
import cn.hdu.po.Department;
import cn.hdu.po.DepartmentVo;
import cn.hdu.po.Doctor;
import cn.hdu.po.DoctorVo;
import cn.hdu.po.Hospital;
import cn.hdu.po.Patient;
import cn.hdu.po.PatientVo;
import cn.hdu.service.DepartmentService;
import cn.hdu.service.HospitalService;
import cn.hdu.service.UserService;

/**
 * 
 * @author wangye 用于处理所有与用户有关的请求
 *
 */
@Controller
public class UserController {

	@Autowired
	@Qualifier("userService") // 根据名称注入
	private UserService userService;

	@Autowired
	@Qualifier("hospitalService")
	private HospitalService hospitalService;

	@Autowired
	@Qualifier("departmentService")
	private DepartmentService departmentService;

	// 医生注册
	@RequestMapping("/doctorRegister.action")
	public ModelAndView doctorRegister(Doctor doctor, String hospitalName, String departmentName) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		Hospital hospital = hospitalService.findHospitalByName(hospitalName);
		if (hospital == null) {
			throw new CustomException("医院科室不能为空，请选择！");
		}
		DepartmentVo departmentVo = new DepartmentVo();
		departmentVo.setHospital(hospital);
		departmentVo.setDepartmentName(departmentName);
		Department department = departmentService.findDepartmentByhospitalIdAndName(departmentVo);
		department.setHospital(hospital);
		doctor.setDepartment(department);

		userService.doctorRegister(doctor);
		modelAndView.addObject("message",
				"<meta http-equiv='refresh' content='3;url=/onlineMedical/doctorLoginPage.action?username="
						+ doctor.getUsername() + "'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/doctorLoginPage.action?username="
						+ doctor.getUsername() + "'>去登录</a>");
		modelAndView.setViewName("message");
		return modelAndView;

	}

	// 患者注册
	@RequestMapping("/patientRegister.action")
	public ModelAndView patientRegister(Patient patient) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		userService.patientRegister(patient);
		modelAndView.addObject("message",
				"<meta http-equiv='refresh' content='2;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient&username="
						+ patient.getUsername()
						+ "'/>恭喜您注册成功，将在2秒后跳转到登录，如果没有跳转，请点击<a href='/patientLoginPage.action?isPatient=isPatient&username="
						+ patient.getUsername() + "'>去登录</a>");
		modelAndView.setViewName("message");
		return modelAndView;

	}

	// 用于跳转到医生注册页面
	@RequestMapping("/doctorRegisterPage.action")
	public String doctorRegisterPage(Model model) throws Exception {
		List<Hospital> hospitals = hospitalService.findAllHospital();
		if (hospitals == null) {
			throw new CustomException("数据库操作异常，请联系管理员！");
		}
		model.addAttribute("hospitals", hospitals);
		return "doctorRegister";
	}

	// 用于跳转到患者注册页面
	@RequestMapping("/patientRegisterPage.action")
	public String patientRegisterPage() throws Exception {

		return "patientRegister";
	}

	// 用于跳转到医生登录页面
	@RequestMapping("/doctorLoginPage.action")
	public String doctorLoginPage(Model model, String username) throws Exception {
		model.addAttribute("username", username);
		return "login";
	}

	// 用于跳转到患者登录页面
	@RequestMapping("/patientLoginPage.action")
	public String patientLoginPage(Model model, String username, String isPatient) throws Exception {
		model.addAttribute("username", username);
		model.addAttribute("isPatient", isPatient);
		return "login";
	}

	// 医生登录
	@RequestMapping("/doctorLogin.action")
	public String doctorLogin(Model model, HttpSession httpSession, DoctorVo doctorVo) throws Exception {
		Doctor doctor = userService.doctorLogin(doctorVo);
		if (doctor == null) {
			throw new CustomException("用户名或密码错误，请正确填写！！！");
		}
		model.addAttribute("doctor", doctor);
		httpSession.setAttribute("doctor", doctor);
		return "doctor";

	}

	// 用于从登录后首页调转到医生个人中心
	@RequestMapping("/indexToDoctor.action")
	public String indexToDoctor(Model model, HttpSession httpSession) throws Exception {
		Doctor doctor = (Doctor) httpSession.getAttribute("doctor");
		if (doctor == null) {
			throw new CustomException(
					"登录失败，重新登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/doctorLoginPage.action'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/doctorLoginPage.action'>去登录</a>");
		}
		model.addAttribute("doctor", doctor);
		return "doctor";
	}

	// 患者登录
	@RequestMapping("/patientLogin.action")
	public String patientLogin(Model model, HttpSession httpSession, PatientVo patientVo) throws Exception {
		Patient patient = userService.patientLogin(patientVo);
		if (patient == null) {
			throw new CustomException("用户名或密码错误，请正确填写！！！");

		}
		model.addAttribute("patient", patient);
		httpSession.setAttribute("patient", patient);
		return "patient";
	}

	// 用于从登录后首页调转到患者个人中心
	@RequestMapping("/indexToPatient.action")
	public String indexToPatient(Model model, HttpSession httpSession) throws Exception {
		Patient patient = (Patient) httpSession.getAttribute("patient");
		if (patient == null) {
			throw new CustomException(
					"登录失败，重新登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/patientLoginPage.action?isPatient=isPatient'>去登录</a>");
		}
		model.addAttribute("patient", patient);
		return "patient";
	}

	// 用显示于医生用户完善个人资料页面，editpage参数不为空时显示编辑页面
	@RequestMapping("/doctorEditPage.action")
	public String doctorEditPage(HttpSession httpSession, Model model, String editPage, String hospitalName)
			throws Exception {
		Doctor doctor = (Doctor) httpSession.getAttribute("doctor");
		if (doctor == null) {
			throw new CustomException(
					"登录失败，重新登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/doctorLoginPage.action'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/doctorLoginPage.action'>去登录</a>");
		}
		model.addAttribute("doctor", doctor);
		List<Hospital> hospitals = hospitalService.findAllHospital();
		if (hospitals == null)
			throw new CustomException("数据库异常,请联系管理员!");
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("editPage", editPage);
		return "doctor";
	}

	// 用于显示患者用户完善个人资料页面，editpage参数不为空时显示编辑页面
	@RequestMapping("/patientEditPage.action")
	public String patientEditPage(HttpSession httpSession, Model model, String editPage) throws Exception {
		Patient patient = (Patient) httpSession.getAttribute("patient");
		if (patient == null) {
			throw new CustomException(
					"登录失败，重新登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/patientLoginPage.action?isPatient=isPatient'>去登录</a>");
		}
		model.addAttribute("patient", patient);
		model.addAttribute("editPage", editPage);
		return "patient";
	}

	// 更新完善患者个人信息
	@RequestMapping("/updatePatient.action")
	public ModelAndView updatePatient(HttpSession httpSession, Patient patient) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Patient p = (Patient) httpSession.getAttribute("patient");
		if (p == null) {
			throw new CustomException(
					"登录失败，重新登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/patientLoginPage.action?isPatient=isPatient'>去登录</a>");
		}
		patient.setId(p.getId());
		userService.updatePatient(patient);
		Patient fullPatient = userService.findPatientById(p.getId());
		if (fullPatient == null) {
			throw new CustomException("数据库异常,请联系管理员!");
		}
		httpSession.removeAttribute("patient");
		httpSession.setAttribute("patient", fullPatient);
		modelAndView.setViewName("patient");
		return modelAndView;

	}

	// 更新完善医生个人信息
	@RequestMapping("/updateDoctor.action")
	public ModelAndView updateDoctor(HttpSession httpSession, Doctor doctor, String hospitalName, String departmentName)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Doctor d = (Doctor) httpSession.getAttribute("doctor");
		if (doctor == null) {
			throw new CustomException(
					"登录失败，重新登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/doctorLoginPage.action'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/doctorLoginPage.action'>去登录</a>");
		}
		doctor.setId(d.getId());
		if (hospitalName == null) {
			throw new CustomException("医院科室不能为空，请选择！");
		}
		Hospital hospital = hospitalService.findHospitalByName(hospitalName);
		DepartmentVo departmentVo = new DepartmentVo();
		departmentVo.setHospital(hospital);
		departmentVo.setDepartmentName(departmentName);
		Department department = departmentService.findDepartmentByhospitalIdAndName(departmentVo);
		department.setHospital(hospital);
		doctor.setDepartment(department);
		userService.updateDoctor(doctor);
		Doctor fullDoctor = userService.findDoctorById(d.getId());
		if (fullDoctor == null) {
			throw new CustomException("数据库异常,请联系管理员!");
		}
		httpSession.removeAttribute("doctor");
		httpSession.setAttribute("doctor", fullDoctor);
		modelAndView.setViewName("doctor");
		return modelAndView;

	}

	// 用户注销
	@RequestMapping("/patientLogout.action")
	public String patientLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "index";
	}

	// 用户注销
	@RequestMapping("/doctorLogout.action")
	public String doctorLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "index";
	}

	// 将科室信息以json数据格式响应
	@RequestMapping("/getDepartmentsByHospitalId.action")
	public @ResponseBody List<Department> getDepartmentsByHospitalId(Model model, String hospitalName)
			throws Exception {
		List<Department> departments = null;
		Hospital hospital = hospitalService.findHospitalByName(hospitalName);
		departments = departmentService.findAllDepartmentByhospitalId(hospital.getId());
		model.addAttribute("departments", departments);
		return departments;
	}
}
