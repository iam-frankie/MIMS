package com.frankie.programmer.entity.admin;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*User实体层
 * 用户实体类
 * 对应数据库里的一张用户表
 */


//自动封装对象，将表单字段自动填充
@Component
public class User {
	private String photo; //头像存储地址
	private Long  id;
	private String username;
	private String password;
	private int sex; //性别0男1女2未知
	private Date birhtday;
	private String address;


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getBirhtday() {
		return birhtday;
	}
	public void setBirhtday(Date birhtday) {
		this.birhtday = birhtday;
	}
}
