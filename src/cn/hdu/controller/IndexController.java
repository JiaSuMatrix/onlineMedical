package cn.hdu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.po.Doctor;
import cn.hdu.po.Patient;

@Controller
public class IndexController {

	@RequestMapping("/index.action")
	public String index(Model model, HttpSession session) {
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (doctor != null) {
			model.addAttribute("doctor", doctor);
		} else {
			Patient patient = (Patient) session.getAttribute("patient");
			if (patient != null)
				model.addAttribute("patient", patient);
		}
		return "index";
	}
}
