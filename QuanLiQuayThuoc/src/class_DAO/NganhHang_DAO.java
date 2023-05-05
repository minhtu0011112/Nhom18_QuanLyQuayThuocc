//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import class_connectDB.ConnectDB;
//import class_entity.NganhHang;
//
//public class NganhHang_DAO{
//	public NganhHang_DAO() {
//	}
//	public ArrayList<NganhHang> getalltbNGH() {
//		ArrayList<NganhHang> listngh = new ArrayList<NganhHang>();
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();	
//			String sql = "Select * from NGANHHANG";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String namengh = rs.getString(1);
//				int md = rs.getInt(2);
//				NganhHang ngh = new NganhHang(namengh, md);	 		
//				listngh.add(ngh);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		
//		}
//		return listngh;
//	}
//	public boolean create(NganhHang ngh) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("insert into NGANHHANG(NGANHHANG, MACDINH)"
//					+ "values(?, ?);");
//			stmt.setString(1, ngh.getTenNganhHang());
//			stmt.setInt(2, ngh.getMacDinh());
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
//	public boolean delete(String ngh) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("DELETE NGANHHANG WHERE NGANHHANG=?");
//			stmt.setString(1, ngh);
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
//}
//
