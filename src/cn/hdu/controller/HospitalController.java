package cn.hdu.controller;
/**
 * @author wangye 用于所有与医院有关的操作
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.service.HospitalService;

@Controller
public class HospitalController {

	@Autowired
	@Qualifier("hospitalService")
	private HospitalService hospitalService;
	
	@RequestMapping("/findHospitalsByName")
	public String findHospitalsByName(Model model) throws Exception{
		
		return "hospitalList";
	}
}
