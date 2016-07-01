package com.common;

import javax.tools.JavaCompiler;

public class User implements java.io.Serializable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private String UserName;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	private String passwd;
}
