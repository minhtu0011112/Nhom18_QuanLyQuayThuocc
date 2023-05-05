package class_DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import class_connectDB.ConnectDB;
import class_entity.NhaCungCap;

public class QuanLyNCC_DAO {
	ConnectDB qlnccConnection;
	
	public ArrayList<NhaCungCap> getAllNCC(){
		ArrayList<NhaCungCap> dsncc = new ArrayList<NhaCungCap>();
		qlnccConnection = new ConnectDB();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String tenNguoiDD = rs.getString(3);
				String diaChi = rs.getString(4);
				String tinh_TP = rs.getString(5);
				String quan_Huyen = rs.getString(6);
				String sDT = rs.getString(7);
				String fax = rs.getString(8);
				String mail = rs.getString(9);
				dsncc.add(new NhaCungCap(maNCC, tenNCC, tenNguoiDD, diaChi, tinh_TP, quan_Huyen, sDT, fax, mail));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return dsncc;
//			catch (SQLException e) {
//			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu!");
//		} finally {
//			qlnccConnection.disconnect();
//		}
//		return dsncc;
	}
	public ArrayList<NhaCungCap> searchNCC(String tenNCC, String tenNguoiDD, String diaChi, String tinh_TP, String quan_Huyen, String sDT, String fax, String mail) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhaCungCap where tenNCC =N'" + tenNCC + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String ten = rs.getString(2);
				String tenNguoi = rs.getString(3);
				String dia = rs.getString(4);
				String tinh = rs.getString(5);
				String quan = rs.getString(6);
				String so = rs.getString(7);
				String fa = rs.getString(8);
				String ema = rs.getString(9);
						
				dsNCC.add(new NhaCungCap(maNCC.trim(), ten.trim(), tenNguoi.trim(), dia.trim(), tinh.trim(), quan.trim(), so.trim(), fa.trim(), ema.trim()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsNCC;
	}
	public boolean addNCC(NhaCungCap ncc) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into NhaCungCap(MaNCC, TenNCC, TenNguoiDD, DiaChi, TinhTP, QuanHuyen, SDT, Fax, Mail) values(?,?,?,?,?,?,?,?,?);");
			stmt.setString(1, ncc.getMaNCC().trim());
			stmt.setString(2, ncc.getTenNCC().trim());
			stmt.setString(3, ncc.getTenNguoiDD().trim());
			stmt.setString(4, ncc.getDiaChi().trim());
			stmt.setString(5, ncc.getTinh_TP().trim());
			stmt.setString(6, ncc.getQuan_Huyen().trim());
			stmt.setString(7, ncc.getSDT().trim());
			stmt.setString(8, ncc.getFax().trim());
			stmt.setString(9, ncc.getMail().trim());
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
	public boolean updateNCC(String maNCC, String tenNCC, String tenNguoiDD, String diaChi, String tinh_TP, String quan_Huyen, String sDT, String fax, String mail) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"Update NhaCungCap " + "set TenNCC=?," + "TenNguoiDD=?, " + " DiaChi =?,"+ "TinhTP=?," +"QuanHuyen=?," +
							"SDT=?," +"Fax=?," +"Mail=?" + " where MaNCC=?");
			stmt.setString(1, tenNCC);
			stmt.setString(2, tenNguoiDD);
			stmt.setString(3, diaChi);
			stmt.setString(4, tinh_TP);
			stmt.setString(5, quan_Huyen);
			stmt.setString(6, sDT);
			stmt.setString(7, fax);
			stmt.setString(8, mail);
			stmt.setString(9, maNCC);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean deleteNCC(String maNCC) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaCungCap where maNCC=?");
			stmt.setString(1, maNCC);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public String tuDongLayMa() {
		String maNCC = "";
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(maNCC) from NhaCungCap), 3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'CC' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maNCC = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maNCC;
	}

}
