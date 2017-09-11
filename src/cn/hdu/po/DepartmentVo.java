package cn.hdu.po;

/**
 * 
 * @author wangye 科室的包装类
 *
 */
public class DepartmentVo {

	private Department department;

	private Hospital hospital;
	
	private String departmentName;

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
