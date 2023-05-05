                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.CTHoaDon;
import class_entity.CTHoaDonCT;
import class_entity.NganhHang;

public class CT_HoaDon_DAO{
	public CT_HoaDon_DAO() {
	}
	public ArrayList<CTHoaDon> getalltbCTHD() {
		ArrayList<CTHoaDon> listCTHD = new ArrayList<CTHoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from CTHoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String maThuoc = rs.getString(2);
				int soLuong = rs.getInt(3);
				String hinhThucBan = rs.getString(4);
				float tongCong = rs.getFloat(5);
				int chietKhau = rs.getInt(6);
				float khachDua = rs.getFloat(7);
				float traKhach = rs.getFloat(8);
				int trangThai = rs.getInt(9);
				CTHoaDon cthd = new CTHoaDon(maHD, maThuoc, soLuong, hinhThucBan, tongCong, chietKhau, khachDua, traKhach, trangThai);
				listCTHD.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listCTHD;
	}
	public boolean create(CTHoaDon cthd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into CTHoaDon(MaHD, MaThuoc, SoLuong, HinhThucBan, TongCong, ChietKhau,"
					+ "KhachDua, TraKhach, TrangThai)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, cthd.getMaHD());
			stmt.setString(2, cthd.getMaThuoc());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setString(4, cthd.getHinhThucBan());
			stmt.setFloat(5, cthd.getTongCong());
			stmt.setInt(6, cthd.getChietKhau());
			stmt.setFloat(7, cthd.getKhachDua());
			stmt.setFloat(8, cthd.getTraKhach());
			stmt.setInt(9, cthd.getTrangThai());
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
	public boolean update(CTHoaDon cthd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update CTHoaDon set MaThuoc=?, SoLuong=?, HinhThucBan=?, "
					+ "TongCong=?, ChietKhau=?, KhachDua=?, TraKhach=?, TrangThai=? where MaHD=?");
			stmt.setString(1, cthd.getMaThuoc());
			stmt.setInt(2, cthd.getSoLuong());
			stmt.setString(3, cthd.getHinhThucBan());
			stmt.setFloat(4, cthd.getTongCong());
			stmt.setInt(5, cthd.getChietKhau());
			stmt.setFloat(6, cthd.getKhachDua());
			stmt.setFloat(7, cthd.getTraKhach());
			stmt.setInt(8, cthd.getTrangThai());
			stmt.setString(9, cthd.getMaHD());
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
	public boolean delete(String cthd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE CTHoaDon WHERE MaHD=?");
			stmt.setString(1, cthd);
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
//	public ArrayList<CTHoaDonCT> getalltbCTCTHD() {
//		ArrayList<CTHoaDonCT> listCTHDCT = new ArrayList<CTHoaDonCT>();
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();	
//			String sql = "Select hd.MaHD, kh.TenKH, ct.SoLuong, ct.TongCong, hd.NgayLapHD, nv.HoTenNV, ct.TrangThai"
//					   + "from CTHoaDon ct, HoaDon hd, NhanVien nv, KhachHang kh"
//					   + "where ct.MaHD = hd.MaHD and hd.MaNV = nv.MaNV and hd.MaKH = kh.MaKH";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String maHD = rs.getString(1);
//				String tenKH = rs.getString(2);
//				int soLuong = rs.getInt(3);
//				float tongCong = rs.getFloat(4);
//				Date ngayLapHD = rs.getDate(5);
//				String hoTenNV = rs.getString(6);
//				int trangThai = rs.getInt(7);
//				CTHoaDonCT cthdct = new CTHoaDonCT(maHD, tenKH, soLuong, tongCong, ngayLapHD, hoTenNV, trangThai);
//				listCTHDCT.add(cthdct);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		
//		}
//		return listCTHDCT;
//	}
}

