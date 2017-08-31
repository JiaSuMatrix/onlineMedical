package cn.hdu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hdu.po.Doctor;
import cn.hdu.po.Patient;
import cn.hdu.service.UserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping("/doctorRegister.action")
	public ModelAndView doctorRegister(Doctor doctor) {
		userService.doctor_register(doctor);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",
				"<meta http-equiv='refresh' content='2;url=/onlineMedical/loginPage.action?username="+doctor.getUsername()+"'/>恭喜您注册成功，将在2秒后跳转到登录，如果没有跳转，请点击<a href='/loginPage.action?username="+doctor.getUsername() +"'>去登录</a>");
		modelAndView.setViewName("message");
		return modelAndView;
	}

	@RequestMapping("/patientRegister.action")
	public ModelAndView patientRegister(Patient patient) {
		userService.patient_register(patient);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",
				"<meta http-equiv='refresh' content='2;url=/onlineMedical/loginPage.action?username="+ patient.getUsername() +"'/>恭喜您注册成功，将在2秒后跳转到登录，如果没有跳转，请点击<a href='/loginPage.action?username="+ patient.getUsername() +"'>去登录</a>");
		modelAndView.setViewName("message");
		return modelAndView;
	}

	@RequestMapping("/loginPage.action")
	public String loginPage(Model model,String username) {
		model.addAttribute("username", username);
		return "login";
	}

	@RequestMapping("/doctorRegisterPage.action")
	public String doctorRegisterPage() {

		return "doctorRegister";
	}

	@RequestMapping("/patientRegisterPage.action")
	public String patientRegisterPage() {

		return "patientRegister";
	}
}
