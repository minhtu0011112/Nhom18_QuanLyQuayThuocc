                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.KhachHang;

public class KhachHang_DAO{
	public KhachHang_DAO() {
	}
	public ArrayList<KhachHang> getalltbKH() {
		ArrayList<KhachHang> listkh = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String maLoaiKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String gioiTinh = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String soCMND = rs.getString(6);
				String diaChi = rs.getString(7);
				String tinh_TP = rs.getString(8);
				String quan_Huyen = rs.getString(9);
				String sdt = rs.getString(10);
				String ghiChu = rs.getString(11);
				KhachHang kh = new KhachHang(maKH, maLoaiKH, tenKH, gioiTinh, ngaySinh, soCMND, diaChi, tinh_TP, quan_Huyen, sdt, ghiChu);
				listkh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listkh;
	}
	public boolean create(KhachHang kh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang(MaKH, MaLoaiKH, TenKH, GioiTinh, NgaySinh, CMND,DiaChi, TinhTP, QuanHuyen,SDT, GhiChu)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getMaLoaiKH());
			stmt.setString(3, kh.getTenKH());
			stmt.setString(4, kh.getGioiTinh());
			stmt.setDate(5, (Date) kh.getNgaySinh());
			stmt.setString(6, kh.getSoCMND());
			stmt.setString(7, kh.getDiaChi());
			stmt.setString(8, kh.getTinh_TP());
			stmt.setString(9, kh.getQuan_Huyen());
			stmt.setString(10, kh.getSdt());
			stmt.setString(11, kh.getGhiChu());
			n = stmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	public boolean update(KhachHang kh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang set MaLoaiKH=?,TenKH=?, GioiTinh=?,NgaySinh=?,CMND=?, DiaChi=?, TinhTP=?,"
					+ "QuanHuyen=?, SDT =?, GhiChu=? where MaKH=?");			
			stmt.setString(1, kh.getMaLoaiKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setDate(4, (Date) kh.getNgaySinh());
			stmt.setString(5, kh.getSoCMND());
			stmt.setString(6, kh.getDiaChi());
			stmt.setString(7, kh.getTinh_TP());
			stmt.setString(8, kh.getQuan_Huyen());
			stmt.setString(9, kh.getSdt());
			stmt.setString(10, kh.getGhiChu());
			stmt.setString(11, kh.getMaKH());
			n = stmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	public boolean delete(String kh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE KhachHang WHERE MaKH=?");
			stmt.setString(1, kh);
			n = stmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	public ArrayList<KhachHang> searchKH(String dieuKien) {
		ArrayList<KhachHang> listkh = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from KhachHang where " + dieuKien;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String maLoaiKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String gioiTinh = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String soCMND = rs.getString(6);
				String diaChi = rs.getString(7);
				String tinh_TP = rs.getString(8);
				String quan_Huyen = rs.getString(9);
				String sdt = rs.getString(10);
				String ghiChu = rs.getString(11);
				KhachHang kh = new KhachHang(maKH, maLoaiKH, tenKH, gioiTinh, ngaySinh, soCMND, diaChi, tinh_TP, quan_Huyen, sdt, ghiChu);
				listkh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listkh;
	}
}

