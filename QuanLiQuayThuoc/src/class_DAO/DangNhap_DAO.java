package class_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.DangNhap;
import class_entity.NhanVien;

public class DangNhap_DAO {
	public DangNhap_DAO() {
	}
	public ArrayList<DangNhap> getalltabledangnhap() {
		ArrayList<DangNhap> dsnv = new ArrayList<DangNhap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = (Statement)con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maNV = rs.getString(1);
				String Pass = rs.getString(2);
				int quyenAdmin = rs.getInt(3);
				DangNhap nv = new DangNhap(maNV, Pass, quyenAdmin);	
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean addTK(DangNhap dn) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan(TenTK, MatKhau, QuanLi) "
					+ "values(?, ?, ?)");
			stmt.setString(1, dn.getMaTK());
			stmt.setString(2, dn.getMatKhau());
			stmt.setInt(3, dn.getQuanLy());
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
	public boolean update(String TenTK, String Pass) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set MatKhau=? where TenTK=?");
			stmt.setString(1, Pass);
			stmt.setString(2, TenTK);
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
	public boolean updateCV(String TenTK, int QuanLi) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set QuanLi=? where TenTK=?");
			stmt.setInt(1, QuanLi);
			stmt.setString(2, TenTK);
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
