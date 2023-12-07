package com.demo;

import com.demo.utils.JDBCUtil;
import javax.swing.JFrame;

import com.demo.view.DangNhapView;

public class App {

  private static JFrame dangNhapView;

  public static void main(String[] args) {
    startUp();
    dangNhapView = new DangNhapView();
    dangNhapView.setVisible(true);
  }

  private static void startUp() {
    JDBCUtil.getDataSource();
  }
}
