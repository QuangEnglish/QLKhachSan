package com.demo.controller;

import java.awt.event.*;

import com.demo.view.QuanLyHoaDonView;
import com.demo.view.TrangChuView;
import java.sql.SQLException;

public class QuanLyHoaDonController implements ActionListener{

	
	private QuanLyHoaDonView quanLyHoaDonView;
	
	public QuanLyHoaDonController(QuanLyHoaDonView qlhdv) {
		quanLyHoaDonView = qlhdv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String giaTri = e.getActionCommand();
		if(giaTri.equals("Lấy thông tin từ số phòng")) {
			try {
				quanLyHoaDonView.Xem(quanLyHoaDonView);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		
		if(giaTri.equals("Thêm")) {
			try {
				quanLyHoaDonView.ThemHoaDon(quanLyHoaDonView);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		
		if(giaTri.equals("Tìm kiếm")) {
			try {
				quanLyHoaDonView.TimKiem();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		
		if(giaTri.equals("In hóa đơn")) {
			try {
				quanLyHoaDonView.InHoaDon(quanLyHoaDonView);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		
		if(giaTri.equals("Quay lại")) {
			TrangChuView.getInstance().setVisible(true);
			quanLyHoaDonView.dispose();
		}
	}
}
