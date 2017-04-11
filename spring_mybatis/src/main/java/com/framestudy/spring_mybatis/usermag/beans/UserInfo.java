package com.framestudy.spring_mybatis.usermag.beans;

import java.io.Serializable;

public class UserInfo implements Serializable,Cloneable {

	/**
	 *   
	 */
	private static final long serialVersionUID = 4948939461570555809L;//序列化ID
	private Long id;
	private String userName;
	private String loginName;
	private String pwd;
	private Integer age;
	
	
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(Long id, String userName, String pwd, Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.age = age;
	}

	
	public UserInfo(Long id, String userName, String loginName, String pwd, Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.loginName = loginName;
		this.pwd = pwd;
		this.age = age;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", pwd=" + pwd + ", age=" + age + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	

}
