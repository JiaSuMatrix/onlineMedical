package cn.hdu.po;

/**
 * 
 * @author wangye 医院实体
 *
 */
public class Hospital {

	// 唯一标识符，采用UUID
	private String id;
	// 医院姓名
	private String name;
	// 医院地址
	private String location;
	// 医院简介
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
