package cn.hdu.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * @author wangye 用于所有与科室有关的操作
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.exception.CustomException;
import cn.hdu.po.Department;
import cn.hdu.po.Hospital;
import cn.hdu.service.DepartmentService;
import cn.hdu.service.HospitalService;

@Controller
public class DepartmentController {

	@Autowired
	@Qualifier("departmentService")
	private DepartmentService departmentService;
	
	@Autowired
	@Qualifier("hospitalService")
	private HospitalService hospitalService;
	
	//根据医院id查出该医院所有的科室
	@RequestMapping("/findAllDepartmentByhospitalId")
	public String findAllDepartmentByhospitalId(Model model, String hospitalId) throws Exception{
		List<Department> departments = departmentService.findAllDepartmentByhospitalId(hospitalId);
		Hospital hospital = hospitalService.findHospitalById(hospitalId);
		if(departments == null || hospital ==null){
			throw new CustomException("数据库操作异常!");
		}
		model.addAttribute("departments", departments);
		model.addAttribute("hospital", hospital);
		return "departments";
	}
}
