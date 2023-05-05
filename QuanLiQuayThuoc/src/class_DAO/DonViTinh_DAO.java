                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.DonViTinh;

public class DonViTinh_DAO{
	
	public ArrayList<DonViTinh> getalltbDVT() {
		ArrayList<DonViTinh> listdvt = new ArrayList<DonViTinh>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from DONVI";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV = rs.getString(1);
				String tenDV = rs.getString(2);
				DonViTinh dvt = new DonViTinh(maDV, tenDV);	 		
				listdvt.add(dvt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listdvt;
	}
	
	public boolean create(DonViTinh dvt) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into DONVI values(?, ?)");
			stmt.setString(1, dvt.getMaDV().trim());
			stmt.setString(2, dvt.getTenDonVi().trim());
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
	public boolean update(DonViTinh dvt) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DonVi set TenDonVi=? where MaDV=?");
			stmt.setString(2, dvt.getMaDV().trim());
			stmt.setString(1, dvt.getTenDonVi().trim());
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
	public boolean delete(String maDV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE DONVI WHERE maDV=?");
			stmt.setString(1, maDV);
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

