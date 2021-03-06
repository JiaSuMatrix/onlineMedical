package cn.hdu.controller;
/**
 * @author wangye 用于所有与医院有关的操作
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.exception.CustomException;
import cn.hdu.po.Hospital;
import cn.hdu.service.HospitalService;


@Controller
public class HospitalController {

	@Autowired
	@Qualifier("hospitalService")
	private HospitalService hospitalService;

	//根据姓名查找医院
	@RequestMapping("/findHospitalByName")
	public String findHospitalsByName(Model model, String name) throws Exception{
		Hospital hospital = hospitalService.findHospitalByName(name);
		if(hospital == null)
			throw new CustomException("数据库操作异常！");
		model.addAttribute("hospital", hospital);
		return "hospital";
	}
}