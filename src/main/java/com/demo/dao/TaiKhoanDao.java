package com.demo.dao;

import com.demo.model.TaiKhoan;
import com.demo.utils.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaiKhoanDao {

  private static final Logger log = LoggerFactory.getLogger(TaiKhoanDao.class);
  private static TaiKhoanDao instance;

  public static TaiKhoanDao getInstance() {
    if (instance == null) {
      synchronized (TaiKhoanDao.class) {
        if (instance == null) {
          instance = new TaiKhoanDao();
        }
      }
    }
    return instance;
  }

  public List<TaiKhoan> selectAll() {
    ArrayList<TaiKhoan> dstk = new ArrayList<>();
    try {
      Connection conn = JDBCUtil.getConnection();

      Statement st = conn.createStatement();
      String sql = "SELECT * FROM TaiKhoan";
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        TaiKhoan taiKhoan = new TaiKhoan(rs.getString("TenTK").trim(),
            rs.getString("MatKhau").trim());
        dstk.add(taiKhoan);
      }
      JDBCUtil.close(conn);

    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return dstk;
  }

  public TaiKhoan getTk(String username) {
    TaiKhoan taiKhoan = null;
    String sql = "SELECT * FROM TaiKhoan where TenTK = ?";
    ResultSet rs = null;
    try (Connection conn = JDBCUtil.getConnection(); PreparedStatement st = conn.prepareStatement(
        sql)) {
      st.setString(1, username);
      rs = st.executeQuery();
      if (rs.next()) {
        taiKhoan = new TaiKhoan(rs.getString("TenTK").trim(), rs.getString("MatKhau").trim());
        return taiKhoan;
      }
    } catch (SQLException e) {
      log.error("ERR", e);
    } finally {
      JDBCUtil.close(rs);
    }
    return taiKhoan;
  }
}
