package class_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.DangNhap;

public class QuanLyTaiKhoan_DAO {
	private ArrayList<DangNhap> dstk;

	public QuanLyTaiKhoan_DAO() {
		dstk = new ArrayList<DangNhap>();
	}

	public ArrayList<DangNhap> getAllTaiKhoan() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from DangNhap";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maTK = rs.getString(1);
				String matKhau = rs.getString(2);
				int quanLy = rs.getInt(3);
				DangNhap tk = new DangNhap(maTK, matKhau, quanLy);
				dstk.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dstk;
	}

	public boolean addTaiKhoan(String maTK, String matKhau, int quanLy) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into DangNhap values(?,?,?)");
			stmt.setString(1, maTK);
			stmt.setString(2, matKhau);
			stmt.setInt(3, quanLy);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public String tuDongLayMa() {
		String maTK = "";
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(maTK) from DangNhap),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'TK' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maTK = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maTK;
	}
}
