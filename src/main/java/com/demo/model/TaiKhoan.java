package com.demo.model;

public class TaiKhoan {
	String tenTk;
	String matKhau;
	
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String tenTk, String matKhau) {
		super();
		this.tenTk = tenTk;
		this.matKhau = matKhau;
	}
	
	public String getTenTk() {
		return tenTk;
	}
	public void setTenTk(String tenTk) {
		this.tenTk = tenTk;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
}
