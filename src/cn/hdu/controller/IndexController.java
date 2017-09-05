package cn.hdu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.po.Doctor;
import cn.hdu.po.Patient;

@Controller
public class IndexController {

	/**
	 * 此方法用于从其他页面返回首页
	 * @param model 模型，将数据带到页面
	 * @param session 会话 存储用户信息
	 * @return 视图名
	 */
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
