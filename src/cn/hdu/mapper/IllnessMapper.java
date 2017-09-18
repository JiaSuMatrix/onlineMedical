package cn.hdu.mapper;

import java.util.List;

import cn.hdu.po.Illness;

public interface IllnessMapper {

	//根据科室id查找疾病
	public List<Illness> findIllnessesByDepartmentId(String departmentId) throws Exception;

}
