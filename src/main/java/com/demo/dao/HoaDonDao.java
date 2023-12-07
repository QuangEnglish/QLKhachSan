package com.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.demo.utils.JDBCUtil;
import com.demo.model.HoaDon;

public class HoaDonDao {

  public int InsertHoaDon(HoaDon hd) throws SQLException {
    int kt = 0;
    Connection conn = JDBCUtil.getConnection();
    try {
      Statement st = conn.createStatement();
      String sql = "INSERT INTO HoaDon VALUES ('" + hd.getSoPhong() + "', " + hd.getMaKH() + ", '"
          + hd.getNgayDat() + "', '" + hd.getNgayTra() + "', " + hd.getThanhTien() + ", N'"
          + hd.getGhiChu() + "')";
      kt = st.executeUpdate(sql);
      JDBCUtil.close(conn);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return kt;
  }

  public ArrayList<HoaDon> selectAllHoaDon() {
    ArrayList<HoaDon> dshd = new ArrayList<>();
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;
    try {
      conn = JDBCUtil.getConnection();
      st = conn.createStatement();
      String sql = "SELECT * FROM HoaDon";
      rs = st.executeQuery(sql);
      while (rs.next()) {
        HoaDon hoaDon = new HoaDon(rs.getInt("MaHD"), rs.getString("SoPhong"), rs.getInt("MaKH"),
            rs.getString("NgayDat"), rs.getString("NgayTra"), rs.getDouble("ThanhTien"),
            rs.getString("GhiChu"));
        dshd.add(hoaDon);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtil.close(rs);
      JDBCUtil.close(st);
      JDBCUtil.close(conn);
    }

    return dshd;
  }

  public HoaDon SelectHoaDonByID(int ID) throws SQLException {
    HoaDon hoaDon = null;
    Connection conn = JDBCUtil.getConnection();
    try {
      Statement st = conn.createStatement();
      String sql = "SELECT * FROM HoaDon WHERE MaHD = " + ID;
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        hoaDon = new HoaDon(rs.getInt("MaHD"), rs.getString("SoPhong"), rs.getInt("MaKH"),
            rs.getString("NgayDat"), rs.getString("NgayTra"), rs.getDouble("ThanhTien"),
            rs.getString("GhiChu"));
      }
      JDBCUtil.close(conn);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return hoaDon;
  }

  public ArrayList<HoaDon> SelectHoaDonByIDSoPhong(int ID, String sp) throws SQLException {
    ArrayList<HoaDon> dshoaDon = new ArrayList<HoaDon>();
    Connection conn = JDBCUtil.getConnection();
    try {
      Statement st = conn.createStatement();
      String sql = "SELECT * FROM HoaDon WHERE MaHD = " + ID + " OR SoPhong = '" + sp + "'";
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        HoaDon hoaDon = new HoaDon(rs.getInt("MaHD"), rs.getString("SoPhong"), rs.getInt("MaKH"),
            rs.getString("NgayDat"), rs.getString("NgayTra"), rs.getDouble("ThanhTien"),
            rs.getString("GhiChu"));
        dshoaDon.add(hoaDon);
      }
      JDBCUtil.close(conn);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return dshoaDon;
  }

  public int CapNhatGhiChu(int ID) throws SQLException {
    int kt = 0;
    Connection conn = JDBCUtil.getConnection();
    try {
      Statement st = conn.createStatement();
      String sql = "UPDATE HoaDon SET GhiChu = N'Đã thanh toán' WHERE MaHD = " + ID;
      kt = st.executeUpdate(sql);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return kt;
  }

}
