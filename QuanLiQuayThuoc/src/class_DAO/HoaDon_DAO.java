                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.CTBan;
import class_entity.HoaDon;
import class_entity.NganhHang;

public class HoaDon_DAO{
	public HoaDon_DAO() {
	}
	public ArrayList<HoaDon> getalltbHD() {
		ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String maNV = rs.getString(2);
				String maKH = rs.getString(3);
				Date ngayLapHD = rs.getDate(4);
				HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayLapHD)	;
				listHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listHD;
	}
	public boolean create(HoaDon hd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon(MaHD, MaNV, MaKH, NgayLapHD)"
					+ "values(?, ?, ?, ?);");
			stmt.setString(1, hd.getMaHD());
			stmt.setString(2, hd.getMaNV());
			stmt.setString(3, hd.getMaKH());
			stmt.setDate(4, (Date) hd.getNgayLapHD());
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
//	public boolean update(NganhHang ngh, String namengh) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("update NGANHHANG set NGANHHANG=?, MACDINH=? where NGANHHANG=?");
//			stmt.setString(1, ngh.getTenNganhHang());
//			stmt.setInt(2, ngh.getMacDinh());
//			stmt.setString(3, namengh);
//			n = stmt.executeUpdate();	
//		} catch (SQLException e) {			
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return n > 0; 
//	}
	public boolean delete(String hd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE HoaDon WHERE MaHD=?");
			stmt.setString(1, hd);
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
//	public ArrayList<HoaDon> getalltbHD() {
//		ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();	
//			String sql = "Select * from HoaDon";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String maHD = rs.getString(1);
//				String maNV = rs.getString(2);
//				String maKH = rs.getString(3);
//				Date ngayLapHD = rs.getDate(4);
//				HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayLapHD)	;
//				listHD.add(hd);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		
//		}
//		return listHD;
//	}
	public ArrayList<CTBan> getalltbCTBan(String maHD) {
		ArrayList<CTBan> listHD = new ArrayList<CTBan>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select ct.MaThuoc, ct.SoLuong \r\n" + 
						 "from HoaDon hd, CTHoaDon ct \r\n" + 
						 "where hd.MaHD = ct.MaHD and hd.MaHD = '" + maHD+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maThuoc = rs.getString(1);
				int soLuong = rs.getInt(2);
				CTBan hd = new CTBan(maThuoc, soLuong);
				listHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listHD;
	}
}

