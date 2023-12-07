package com.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.demo.utils.JDBCUtil;
import com.demo.model.KhachHang;

public class KhachHangDao {
	public static KhachHangDao getInstance() {
		return new KhachHangDao();
	}
	
	public boolean isKhachHangExists(KhachHang khachHang) {
		boolean isHas = false;
		try {
			Connection conn = JDBCUtil.getConnection();	
			Statement st = conn.createStatement();
			
			String query = "SELECT * FROM KhachHang WHERE CCCD = " + "'" + khachHang.getCCCD() + "'";
			ResultSet rs = st.executeQuery(query);
			isHas = rs.next();
			System.out.println(isHas);
			
			JDBCUtil.close(conn);
		} catch (Exception e) {
			
		}
		return isHas;
	}
	
	public int insertOrUpdate(KhachHang khachHang) {
		int res = 0;
		
		if (isKhachHangExists(khachHang)) res = updateKhachHang(khachHang);
		else res = insertKhachHang(khachHang);
		
		return res;
	}

	private int insertKhachHang(KhachHang khachHang) {
		int res = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();
			
			String query = "INSERT INTO KhachHang VALUES(N'" + khachHang.getTenKH() + "', N'" + khachHang.getGioiTinh() + "', '" + khachHang.getNgaySinh() + "', '" + khachHang.getCCCD() + "', N'" + khachHang.getDiaChi() + "', '" + khachHang.getSDT() + "')"; 
			res = st.executeUpdate(query);
			JDBCUtil.close(conn);
		} catch (Exception e) {
			System.out.println("Lỗi");
		}
		return res;
	}

	private int updateKhachHang(KhachHang khachHang) {
		int res = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();
			
			String query = "UPDATE KhachHang SET TenKH = N'" + khachHang.getTenKH() + "', GioiTinh = N'" + khachHang.getGioiTinh() + "', NgaySinh = '" + khachHang.getNgaySinh() + "', DiaChi = N'" + khachHang.getDiaChi() + "', SDT = '" + khachHang.getSDT() + "' WHERE CCCD = '" + khachHang.getCCCD() + "'"; 
			res = st.executeUpdate(query);
			JDBCUtil.close(conn);
		} catch (Exception e) {
			System.out.println("Lỗi");
		}
		return res;		
	}
	
	public KhachHang SelectKhachHangByID(int ID) throws SQLException {
		KhachHang kh = null;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM KhachHang WHERE MaKH = " + ID;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				kh = new KhachHang(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("GioiTinh"), rs.getString("CCCD"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("NgaySinh"));
			}
			JDBCUtil.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kh;	
	}
	
	public KhachHang SelectKhachHangByCCCD(String CCCD) throws SQLException {
		KhachHang kh = null;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM KhachHang WHERE CCCD = '" + CCCD + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				kh = new KhachHang(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("GioiTinh"), rs.getString("CCCD"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("NgaySinh"));
			}
			JDBCUtil.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kh;	
	}
	
	public int InsertKhachHang(KhachHang kh) throws SQLException {
		int kt = 0;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "INSERT INTO KhachHang VALUES (N'" + kh.getTenKH() + "', N'" + kh.getGioiTinh() + "', '" + kh.getNgaySinh() + "', '" + kh.getCCCD() + "', N'" + kh.getDiaChi() + "', '" + kh.getSDT() + "')";
			kt = st.executeUpdate(sql);
			JDBCUtil.close(conn);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kt;
	}
	
	public int UpdateKhachHang(KhachHang kh) throws SQLException {
		int kt = 0;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "UPDATE KhachHang SET TenKH = N'" + kh.getTenKH() + "', GioiTinh = N'" + kh.getGioiTinh() + "', NgaySinh = '" + kh.getNgaySinh() + "', CCCD = '" + kh.getCCCD() + "', DiaChi = N'" + kh.getDiaChi() + "', SDT = '" + kh.getSDT() + "' WHERE MaKH = " + kh.getMaKH();
			kt = st.executeUpdate(sql);
			JDBCUtil.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return kt;
	}
	
	public int DeleteKhachHang(int maKH) throws SQLException {
		int kt = 0;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "DELETE FROM KhachHang WHERE MaKh = " + maKH;
			kt = st.executeUpdate(sql);
			JDBCUtil.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return kt;
	}
	
	public ArrayList<KhachHang> SelectAll() throws SQLException {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM KhachHang";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				KhachHang kh = new KhachHang(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("GioiTinh"), rs.getString("CCCD"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("NgaySinh"));
				dsKhachHang.add(kh);
			}
			JDBCUtil.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	public ArrayList<KhachHang> timKiemTheoTen(String con1) throws SQLException {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "Select * from KhachHang where TenKH like N'%" + con1 + "%'"  ;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(5);
				KhachHang kh = new KhachHang(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("GioiTinh"), rs.getString("CCCD"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("NgaySinh"));
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
}
