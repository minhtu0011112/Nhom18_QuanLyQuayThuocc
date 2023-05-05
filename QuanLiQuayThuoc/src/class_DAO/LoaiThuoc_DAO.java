                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.LoaiThuoc;

public class LoaiThuoc_DAO{
	public ArrayList<LoaiThuoc> getAllLoaiThuoc() {
		ArrayList<LoaiThuoc> listLT = new ArrayList<LoaiThuoc>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select maLoaiT,tenLoaiThuoc from LoaiThuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoai = rs.getString(1);
				String tenLoai = rs.getString(2);
				LoaiThuoc ngh = new LoaiThuoc(maLoai, tenLoai);	 		
				listLT.add(ngh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLT;
	}
	public ArrayList<LoaiThuoc> getAllLTDD(String maThuoc) {
		ArrayList<LoaiThuoc> listngh = new ArrayList<LoaiThuoc>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select LoaiThuoc.maLoaiT,LoaiThuoc.tenLoaiThuoc\r\n"
			+" from LoaiThuoc join Thuoc\r\n" + "on LoaiThuoc.maLoaiT=Thuoc.maLoaiT\r\n"
			+" where Thuoc.maThuoc = '" + maThuoc + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoai = rs.getString(1);
				String tenLoai = rs.getString(2);
				LoaiThuoc ngh = new LoaiThuoc(maLoai, tenLoai);	 		
				listngh.add(ngh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listngh;
	}
	public boolean create(String ma,String tenLoaiThuoc) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into LoaiThuoc values(?, ?)");
			stmt.setString(1, ma);
			stmt.setString(2, tenLoaiThuoc);
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
	public boolean update(String maLoai, String tenLoai) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update LoaiThuoc set tenLoaiThuoc=? where maLoaiT=?");
			stmt.setString(1, tenLoai);
			stmt.setString(2, maLoai);
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
	public boolean delete(String maLoai) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE LoaiThuoc WHERE maLoaiT=?");
			stmt.setString(1, maLoai);
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
	public String tuDongLayMa() {
		String maLoai = "";
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(maLoaiT) from LoaiThuoc),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'LT' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maLoai = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maLoai;
	}
}

