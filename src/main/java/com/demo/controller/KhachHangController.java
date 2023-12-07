package com.demo.controller;

import java.awt.event.*;

import com.demo.view.QuanLyKhachHangView;
import com.demo.view.TrangChuView;
import java.sql.SQLException;

public class KhachHangController implements ActionListener, MouseListener {
	
	QuanLyKhachHangView quanLyKhachHangView;
	
	public KhachHangController(QuanLyKhachHangView qlkh) {
		this.quanLyKhachHangView = qlkh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String giaTri = e.getActionCommand();
		
		if(giaTri.equals("Thêm")) {
			try {
				quanLyKhachHangView.ThemKhachHang();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		
		if(giaTri.equals("Sửa")) {
			try {
				quanLyKhachHangView.Sua();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		
		if(giaTri.equals("Xóa")) {
			try {
				quanLyKhachHangView.Xoa();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		if(giaTri.equals("Tìm kiếm")) {
			try {
				quanLyKhachHangView.TimKiem();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		if(giaTri.equals("Quay lại")) {
			TrangChuView.getInstance().setVisible(true);
			quanLyKhachHangView.dispose();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			quanLyKhachHangView.LayDong();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
