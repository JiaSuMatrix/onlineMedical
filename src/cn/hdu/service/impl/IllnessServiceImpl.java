package cn.hdu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.exception.CustomException;
import cn.hdu.mapper.IllnessMapper;
import cn.hdu.po.Illness;
import cn.hdu.service.IllnessService;

public class IllnessServiceImpl implements IllnessService {

	@Autowired
	@Qualifier("illnessMapper")
	private IllnessMapper illnessMapper;
	
	//根据科室id查找疾病
	@Override
	public List<Illness> findIllnessesByDepartmentId(String departmentId) throws Exception {
		List<Illness> illnesses = illnessMapper.findIllnessesByDepartmentId(departmentId);
		if (illnesses != null) {
			return illnesses;
		}
		return null;
	}
	
	//根据疾病ID查找illness
	@Override
	public Illness findIllnessById(String illnessId) throws Exception{
		Illness illness = illnessMapper.findIllnessById(illnessId);
		if (illness != null) {
			return illness;
		}
		return null;
	}

}
