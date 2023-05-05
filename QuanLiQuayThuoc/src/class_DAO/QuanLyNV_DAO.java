package class_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.NhanVien;

public class QuanLyNV_DAO {

	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> qlnv = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhanVien where tinhTrang !=0 or tinhTrang != NULL";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNv = rs.getString(1);
				String tenNV = rs.getString(2);
				String chucVu = rs.getString(3);
				String gioiTinh = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				Date ngayLamViec = rs.getDate(6);
				String cmnd = rs.getString(7);
				String diaChi = rs.getString(8);
				String quanHuyen = rs.getString(9);
				String tinhTP = rs.getString(10);
				String email = rs.getString(11);
				String sdt = rs.getString(12);
				int trangThai = rs.getInt(13);
				NhanVien nv = new NhanVien(maNv, tenNV, chucVu, gioiTinh, ngaySinh, ngayLamViec, cmnd, diaChi,
						quanHuyen, tinhTP, email, sdt, trangThai);
				qlnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlnv;

	}
	public ArrayList<NhanVien> getAllNhanVienall() {
		ArrayList<NhanVien> qlnv = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhanVien";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNv = rs.getString(1);
				String tenNV = rs.getString(2);
				String chucVu = rs.getString(3);
				String gioiTinh = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				Date ngayLamViec = rs.getDate(6);
				String cmnd = rs.getString(7);
				String diaChi = rs.getString(8);
				String quanHuyen = rs.getString(9);
				String tinhTP = rs.getString(10);
				String email = rs.getString(11);
				String sdt = rs.getString(12);
				int trangThai = rs.getInt(13);
				NhanVien nv = new NhanVien(maNv, tenNV, chucVu, gioiTinh, ngaySinh, ngayLamViec, cmnd, diaChi,
						quanHuyen, tinhTP, email, sdt, trangThai);
				qlnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlnv;

	}

	public boolean addNV(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien(MaNV, HoTenNV, ChucVu , GioiTinh, NgaySinh, NgayVaoLam, CMND, DiaChi, QuanHuyen, TinhTP, Email, SDT, TinhTrang) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getChuVu());
			stmt.setString(4, nv.getGioiTinh());
			stmt.setDate(5, (Date) nv.getNgaySinh());
			stmt.setDate(6, (Date) nv.getNgayLamViec());
			stmt.setString(7, nv.getcMND());
			stmt.setString(8, nv.getDiaChi());
			stmt.setString(9, nv.getQuanHuyen());
			stmt.setString(10, nv.getTinhTP());
			stmt.setString(11, nv.getEmail());
			stmt.setString(12, nv.getSdt());
			stmt.setInt(13, nv.getTinhTrang());	
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

	public boolean updateNV(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update NhanVien " + "set HoTenNV=?," + "ChucVu=?," + "GioiTinh=?,"
					+ "NgaySinh=?," + "NgayVaoLam=?," + "CMND=?," + "DiaChi=?," + "QuanHuyen=?," + "TinhTP=?," + "Email=?," + "SDT=?," + "TinhTrang=?"
					+ " where MaNV=?");
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getChuVu());
			stmt.setString(3, nv.getGioiTinh());
			stmt.setDate(4, (Date) nv.getNgaySinh());
			stmt.setDate(5, (Date) nv.getNgayLamViec());
			stmt.setString(6, nv.getcMND());
			stmt.setString(7, nv.getDiaChi());
			stmt.setString(8, nv.getQuanHuyen());
			stmt.setString(9, nv.getTinhTP());
			stmt.setString(10, nv.getEmail());
			stmt.setString(11, nv.getSdt());
			stmt.setInt(12, nv.getTinhTrang());	
			stmt.setString(13, nv.getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean deleteNV(String manV,int tinhTrang) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update NhanVien " + " set tinhTrang=?" + " where maNV=?");
		
			stmt.setInt(1, tinhTrang);
			stmt.setString(2, manV);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<NhanVien> searchNV(String dieuKien) {
		ArrayList<NhanVien> dstimNV = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhanVien where " + dieuKien;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNv = rs.getString(1);
				String tenNV = rs.getString(2);
				String chucVu = rs.getString(3);
				String gioiTinh = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				Date ngayLamViec = rs.getDate(6);
				String cmnd = rs.getString(7);
				String diaChi = rs.getString(8);
				String quanHuyen = rs.getString(9);
				String tinhTP = rs.getString(10);
				String email = rs.getString(11);
				String sdt = rs.getString(12);
				int trangThai = rs.getInt(13);
				NhanVien nv = new NhanVien(maNv, tenNV, chucVu, gioiTinh, ngaySinh, ngayLamViec, cmnd, diaChi,
						quanHuyen, tinhTP, email, sdt, trangThai);
				dstimNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dstimNV;
	}

	public String tuDongLayMa() {
		String maNV = "";
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(maNV) from NhanVien),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'NV' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maNV = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maNV;
	}

}
