package com.demo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import javax.swing.JFrame;
import com.demo.view.NhanVienView;
import com.demo.view.QuanLyHoaDonView;
import com.demo.view.QuanLyKhachHangView;
import com.demo.view.QuanLyPhong;
import com.demo.view.TrangChuView;

public class TrangChuController implements ActionListener {
	private TrangChuView view;

	public TrangChuController(TrangChuView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command.equals("Quản lý phòng")) {
			try {
				openQuanLyPhong();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		} else if (command.equals("Quản lý nhân viên")) {
			try {
				openQuanLyNhanVien();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		} else if (command.equals("Thông tin khách hàng")) {
			try {
				openThongTinKhachHang();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		} else if (command.equals("Quản lý hóa đơn")) {
			try {
				openQuanLyHoaDon();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	private void openThongTinKhachHang() throws SQLException {
		JFrame frame = new QuanLyKhachHangView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		view.setVisible(false);
	}

	private void openQuanLyPhong() throws SQLException {
		QuanLyPhong.refresh();
		QuanLyPhong.getInstance().setVisible(true);
		QuanLyPhong.getInstance().setLocationRelativeTo(null);
		view.setVisible(false);
	}

	private void openQuanLyHoaDon() throws SQLException {
		QuanLyHoaDonView.refresh();
		QuanLyHoaDonView.getInstance().setVisible(true);
		QuanLyHoaDonView.getInstance().setLocationRelativeTo(null);
		view.setVisible(false);
	}

	private void openQuanLyNhanVien() throws SQLException {
		JFrame quanLyNhanVienView = new NhanVienView();
		quanLyNhanVienView.setVisible(true);
		quanLyNhanVienView.setLocationRelativeTo(null);
		view.setVisible(false);
	}
}
