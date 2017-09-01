package cn.hdu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hdu.po.Doctor;
import cn.hdu.po.DoctorVo;
import cn.hdu.po.Patient;
import cn.hdu.po.PatientVo;
import cn.hdu.service.UserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping("/doctorRegister.action")
	public ModelAndView doctorRegister(Doctor doctor) {
		userService.doctorRegister(doctor);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",
				"<meta http-equiv='refresh' content='2;url=/onlineMedical/doctorLoginPage.action?username="
						+ doctor.getUsername()
						+ "'/>恭喜您注册成功，将在2秒后跳转到登录，如果没有跳转，请点击<a href='/doctorLoginPage.action?username="
						+ doctor.getUsername() + "'>去登录</a>");
		modelAndView.setViewName("message");
		return modelAndView;
	}

	@RequestMapping("/patientRegister.action")
	public ModelAndView patientRegister(Patient patient) {
		userService.patientRegister(patient);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",
				"<meta http-equiv='refresh' content='2;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient&username="
						+ patient.getUsername()
						+ "'/>恭喜您注册成功，将在2秒后跳转到登录，如果没有跳转，请点击<a href='/patientLoginPage.action?isPatient=isPatient&username="
						+ patient.getUsername() + "'>去登录</a>");
		modelAndView.setViewName("message");
		return modelAndView;
	}

	@RequestMapping("/doctorRegisterPage.action")
	public String doctorRegisterPage() {

		return "doctorRegister";
	}

	@RequestMapping("/patientRegisterPage.action")
	public String patientRegisterPage() {

		return "patientRegister";
	}

	@RequestMapping("/doctorLoginPage.action")
	public String doctorLoginPage(Model model, String username) {
		model.addAttribute("username", username);
		return "login";
	}

	@RequestMapping("/patientLoginPage.action")
	public String patientLoginPage(Model model, String username, String isPatient) {
		model.addAttribute("username", username);
		model.addAttribute("isPatient", isPatient);
		return "login";
	}

	@RequestMapping("/doctorLogin.action")
	public String doctorLogin(Model model, HttpSession httpSession, DoctorVo doctorVo) {
		Doctor doctor = userService.doctorLogin(doctorVo);
		if (doctor != null) {
			model.addAttribute("username", doctor.getUsername());
			httpSession.setAttribute("doctor", doctor);
			return "doctor";
		}else{
			model.addAttribute("message", "用户名或密码错误，请正确填写！！！");
			return "message";
		}
		
	}

	@RequestMapping("/patientLogin.action")
	public String patientLogin(Model model, HttpSession httpSession, PatientVo patientVo) {
		Patient patient = userService.patientLogin(patientVo);
		if (patient != null) {
			model.addAttribute("username", patient.getUsername());
			httpSession.setAttribute("patient", patient);
			return "patient";
		}else{
			model.addAttribute("message", "用户名或密码错误，请正确填写！！！");
			return "message";
		}
		
	}
}
