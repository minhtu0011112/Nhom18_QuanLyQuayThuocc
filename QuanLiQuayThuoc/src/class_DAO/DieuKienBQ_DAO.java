                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.DieuKienBQ;

public class DieuKienBQ_DAO{
	public DieuKienBQ_DAO() {
	}
	public ArrayList<DieuKienBQ> getalltbDKBQ() {
		ArrayList<DieuKienBQ> listdkbq = new ArrayList<DieuKienBQ>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from DIEUKIENBAOQUAN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String namedkbq = rs.getString(1);;
				DieuKienBQ dkbq = new DieuKienBQ(namedkbq);	 		
				listdkbq.add(dkbq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listdkbq;
	}
	public boolean create(DieuKienBQ dkbq) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into DIEUKIENBAOQUAN(DIEUKIENBAOQUAN)"
					+ "values(?);");
			stmt.setString(1,dkbq.getDieuKienBaoQuan());
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
	public boolean update(DieuKienBQ dkbq, String namedkbq1) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DIEUKIENBAOQUAN set DIEUKIENBAOQUAN=? where DIEUKIENBAOQUAN=?");
			stmt.setString(1, dkbq.getDieuKienBaoQuan());
			stmt.setString(2, namedkbq1);
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
	public boolean delete(String dkbq) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE DIEUKIENBAOQUAN WHERE DIEUKIENBAOQUAN=?");
			stmt.setString(1, dkbq);
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
}

