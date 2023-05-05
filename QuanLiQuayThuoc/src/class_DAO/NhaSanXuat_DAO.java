package class_DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import class_connectDB.ConnectDB;
import class_entity.NhaSanXuat;
import class_entity.NhanVien;

public class NhaSanXuat_DAO {
	public ArrayList<NhaSanXuat> docTuBang() {
		ArrayList<NhaSanXuat> dsNSX = new ArrayList<NhaSanXuat>();
		try {
			Connection ketnoi = ConnectDB.getConnection();
			String sql = "select * from NhaSanXuat n\r\n";
			Statement Starement = ketnoi.createStatement();
			ResultSet rs = Starement.executeQuery(sql);
			while (rs.next()) {
				String maNSX = rs.getString(1);
				String tenNSX = rs.getString(2);
				String sDT = rs.getString(3);
				String fax = rs.getString(4);
				String email = rs.getString(5);
				
				NhaSanXuat nCC = new NhaSanXuat(maNSX, tenNSX, sDT, fax, email);
				dsNSX.add(nCC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNSX;
	}
	public ArrayList<NhaSanXuat> timNSX(String tenNSX) { //String tenNSX, String sDT, String fax, String eMail, String quocGia
		ArrayList<NhaSanXuat> dsNSX = new ArrayList<NhaSanXuat>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
//			String sql = "select n.MaNSX,n.tenNSX,n.SDT,n.Fax,n.Email\r\n"
//			+" from NhaSanXuat n "
//			+" where n.tenNSX =N'%" + tenNSX + "%' and n.SDT='%" + sDT +"%'";
			String sql = "select n.MaNSX,n.tenNSX,n.SDT,n.Fax,n.Email\r\n"
					+ " from NhaSanXuat n"
					+ " where n.tenNSX = N'%" + tenNSX +"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNSX = rs.getString(1);
				String ten = rs.getString(2);
				String dt = rs.getString(3);
				String fa = rs.getString(4);
				String email = rs.getString(5);
						
				dsNSX.add(new NhaSanXuat(maNSX, tenNSX, dt, fa, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsNSX;
	}
	public ArrayList<NhaSanXuat> searchNSX(String dieuKien) {
		ArrayList<NhaSanXuat> dstimNSX = new ArrayList<NhaSanXuat>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhaSanXuat where " + dieuKien;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNSX = rs.getString(1);
				String tenNSX = rs.getString(2);
				String sDT= rs.getString(3);
				String fax = rs.getString(4);
				String email = rs.getString(5);
				NhaSanXuat nsx = new NhaSanXuat(maNSX, tenNSX, sDT, fax, email);
				dstimNSX.add(nsx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dstimNSX;
	}
	public boolean themNSX(String maNSX, String tenNSX, String sDT, String fax, String eMail) {
		Connection ketnoi = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = ketnoi.prepareStatement("insert NhaSanXuat values(?,?,?,?,?)");
			stmt.setString(1, maNSX);
			stmt.setString(2, tenNSX);
			stmt.setString(3, sDT);
			stmt.setString(4, fax);
			stmt.setString(5, eMail);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhapNSX(String maNSX, String tenNSX, String sDT, String fax, String eMail) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		int n = 0;
		try {
			preparedStatement = connection.prepareStatement("update NhaSanXuat set TenNSX=?,SDT=?,Fax=?,Email=? where NhaSanXuat.maNSX=?");
			preparedStatement.setString(1, tenNSX);
			preparedStatement.setString(2, sDT);
			preparedStatement.setString(3, fax);
			preparedStatement.setString(4, eMail);
			preparedStatement.setString(5, maNSX);
			n = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deleteNSX(String maNSX) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaSanXuat where maNSX=?");
			stmt.setString(1, maNSX);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public String tuDongLayMa() {
		String maNSX = "";
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(maNSX) from NhaSanXuat),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'SX' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maNSX = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maNSX;
	}

}
