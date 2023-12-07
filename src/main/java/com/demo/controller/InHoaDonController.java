package com.demo.controller;

import java.awt.event.*;

import com.demo.view.InHoaDonView;
import java.sql.SQLException;

public class InHoaDonController implements ActionListener{
	
	InHoaDonView inHoaDonView;
	
	public InHoaDonController(InHoaDonView in) {
		this.inHoaDonView = in;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String giaTri = e.getActionCommand();
		if(giaTri.equals("Hủy")) {
			inHoaDonView.Huy();
		}
		
		if(giaTri.equals("In hóa đơn")) {
			try {
				inHoaDonView.InHoaDon(inHoaDonView);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

}
