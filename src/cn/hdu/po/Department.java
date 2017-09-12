package cn.hdu.po;

/**
 * 
 * @author wangye 科室实体
 *
 */
public class Department {

	// 唯一标识符，采用UUID
	private String id;
	// 科室名
	private String departmentName;
	// 所属医院
	private Hospital hospital;

	public String getId() {
		return id;
	}

	
	public Hospital getHospital() {
		return hospital;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
