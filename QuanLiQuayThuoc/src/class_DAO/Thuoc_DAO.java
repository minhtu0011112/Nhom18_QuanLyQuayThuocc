                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.Thuoc;

public class Thuoc_DAO{
	public ArrayList<Thuoc> getAlltbThuoc() {
		ArrayList<Thuoc> dsThuoc =  new ArrayList<Thuoc>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG,HoatChat
			String sql = "select * from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maThuoc = rs.getString(1);
				String tenThuoc = rs.getString(2);
				float giaBan = rs.getFloat(3);
				int soLuong = rs.getInt(4);
				String moTa = rs.getString(5);
				String maNSX = rs.getString(6);
				String maLoai = rs.getString(7);
				String maDV = rs.getString(8);
				String maQG = rs.getString(9);
				Thuoc T = new Thuoc(maThuoc, tenThuoc, giaBan, soLuong, moTa, maNSX, maLoai, maDV, maQG); 		
				dsThuoc.add(T);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThuoc;
	}
//	public ArrayList<Thuoc> getAllThuocDD() {
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG,HoatChat
//			String sql = "select Thuoc.maThuoc,Thuoc.TenThuoc,Thuoc.GiaBan,Thuoc.SoLuong,Thuoc.MoTa,NhaSanXuat.TenNSX,LoaiThuoc.TenLoaiThuoc,\r\n"
//					+ "DonVi.TenDonVi,QuocGia.tenQuocGia,HoatChat.tenHoatChat\r\n"
//					+ "from Thuoc join LoaiThuoc " + "on Thuoc.maLoaiT=LoaiThuoc.maLoaiT\r\n"
//					+ "			  join NhaSanXuat " + "on NhaSanXuat.maNSX=Thuoc.maNSX\r\n"
//					+ "           join DonVi " + "on DonVi.maDV=Thuoc.maDV\r\n"
//					+ "           join QuocGia" + " on QuocGia.maQG=Thuoc.maQG\r\n"
//					+ "           join HoatChat" + " on HoatChat.maHC=Thuoc.maHC\r\n"
//					+ "where TinhTrang  = 1";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String maThuoc = rs.getString(1);
//				String tenThuoc = rs.getString(2);
//				float giaBan = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String moTa = rs.getString(5);
//				String nhaSanXuat = rs.getString(6);
//				String loaiThuoc = rs.getString(7);
//				String donViTinh = rs.getString(8);
//				String quocGia = rs.getString(9);
//				String hoatChat = rs.getString(10);
//			
//				Thuoc T = new Thuoc(maThuoc, tenThuoc, giaBan, soLuong, moTa, nhaSanXuat, loaiThuoc, donViTinh, quocGia, hoatChat); 		
//				dsThuoc.add(T);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsThuoc;
//	}
//	public boolean themThuocDD(String maThuoc, String tenThuoc, String moTa, String tenLoaiThuoc, String tenNSX,String quocGia, String donViTinh,String hoatChat, float giaBan, int soLuong,int TinhTrang) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("\r\n" + "declare @maLoaiT char(8),@maNSX char(8),@maDV char(8),@maQG char(8),@maHC char(8)\r\n"
//					+ "select @maLoaiT = maLoaiT\r\n" + "from LoaiThuoc\r\n" + "where TenLoaiThuoc = ?\r\n"
//					+ "select @maNSX = maNSX\r\n" + "from NhaSanXuat\r\n" + "where TenNSX = ?\r\n"
//					+ "select @maDV = maDV\r\n" + "from DonVi\r\n" + "where TenDonVi = ?\r\n"
//					+ "select @maQG = maQG\r\n" + "from QuocGia\r\n" + "where TenQuocGia = ?\r\n"
//					+ "select @maHC = maHC\r\n" + "from HoatChat\r\n" + "where TenHoatChat = ?\r\n"
//					+ "insert Thuoc values(?,?,?,?,?,@maNSX,@maLoai,@maDV,@maQG,@maHC,?)");
//			//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG,HoatChat
//			stmt.setString(1, tenLoaiThuoc);
//			stmt.setString(2, tenNSX);
//			stmt.setString(3, donViTinh);
//			stmt.setString(4, quocGia);
//			stmt.setString(5, hoatChat);
//			stmt.setString(6, maThuoc);
//			stmt.setString(7, tenThuoc);
//			stmt.setFloat(8, giaBan);
//			stmt.setInt(9, soLuong);
//			stmt.setString(10, moTa);
//			stmt.setInt(11, TinhTrang);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return n > 0;
//	}
	
	public boolean themThuoc(Thuoc t) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Thuoc values(?, ?, ?, ?, ?, ?, ?, ?, ?);");
			//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG
			stmt.setString(1, t.getMaThuoc());
			stmt.setString(2, t.getTenThuoc());
			stmt.setFloat(3, t.getGiaBan());
			stmt.setInt(4, t.getSoLuong());
			stmt.setString(5, t.getMoTa());
			stmt.setString(6, t.getMaNSX());
			stmt.setString(7, t.getMaLoai());
			stmt.setString(8, t.getMaDV());
			stmt.setString(9, t.getMaQG());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean xoa(String maThuoc) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete Thuoc where MaThuoc = ?");
			stmt.setString(1, maThuoc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
//	public boolean capnhatDD(String maThuoc, String tenThuoc, float giaBan, int soLuong, String moTa,String tenNSX,String quocGia,String hoatChat,String tenLoai,String tenDonVi) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("declare @maLoaiT char(8),@maNSX char(8),@maDV char(8),@maQG char(8\r\n"
//					+ "select @maLoaiT = maLoaiT\r\n" + "from LoaiThuoc\r\n" + "where tenLoaiThuoc = ?\r\n"
//					+ "select @maNSX = maNSX\r\n" + "from NhaSanXuat\r\n" + "where tenNSX = ?\r\n"
//					+ "select @maDV = maDV\r\n" + "from DonVi\r\n" + "where TenDonVi = ?\r\n"
//					+ "select @maQG = maQG\r\n" + "from QuocGia\r\n" + "where TenQuocGia = ?\r\n"
//					+ "select @maHC = maHC\r\n" + "from HoatChat\r\n" + "where TenHoatChat = ?\r\n"
//					+ "update Thuoc set TenThuoc = ?,GiaBan=?,SoLuong=?,MoTa = ?,maNSX = @maNSX,maLoaiT=@maLoaiT,maDV=@maDV,maQG=@maQG,maHC=@maHC where maThuoc = ?");
//			//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG,HoatChat
//			stmt.setString(1, tenLoai);
//			stmt.setString(2, tenNSX);
//			stmt.setString(3, tenDonVi);
//			stmt.setString(4, quocGia);
//			stmt.setString(5, hoatChat);
//			stmt.setString(6, tenThuoc);
//			stmt.setString(7, moTa);
//			stmt.setFloat(8, giaBan);
//			stmt.setInt(9, soLuong);
//			stmt.setString(10, maThuoc);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
//	}

	public boolean capnhat(Thuoc t) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Thuoc set TenThuoc=?, GiaBan=?, SoLuong=?, MoTa = ?, MaNSX = ?, MaLoaiT=?, MaDV=?, MaQG=? where MaThuoc = ?");
			//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG
			stmt.setString(1, t.getTenThuoc());
			stmt.setFloat(2, t.getGiaBan());
			stmt.setInt(3, t.getSoLuong());
			stmt.setString(4, t.getMoTa());
			stmt.setString(5, t.getMaNSX());
			stmt.setString(6, t.getMaLoai());
			stmt.setString(7, t.getMaDV());
			stmt.setString(8, t.getMaQG());
			stmt.setString(9, t.getMaThuoc());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<Thuoc> timKiem(String tenT, String tenNSX, String tenLoai) {
		ArrayList<Thuoc> dsThuoc =  new ArrayList<Thuoc>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "\r\n" + "select Thuoc.maThuoc,Thuoc.TenThuoc,Thuoc.GiaBan,Thuoc.SoLuong,Thuoc.MoTa,Thuoc.maNSX,Thuoc.maLoaiT,\r\n"
					+ "Thuoc.maDV,Thuoc.maQG,Thuoc.maHC\r\n"
					+ "from Thuoc join LoaiThuoc\r\n" + "on Thuoc.maLoaiT=LoaiThuoc.maLoaiT\r\n"
					+ "			  join NhaSanXuat\r\n" + "on NhaSanXuat.maNSX=Thuoc.maNSX\r\n" 
					+ "           join DonVi\r\n" + "on DonVi.maDV=Thuoc.maDV\r\n"
					+ "           join HoatChat\r\n" + "on HoatChat.maHC=Thuoc.maHC"
					+ "where Thuoc.TenThuoc like N'%" + tenT + "%' and NhaSanXuat.tenNSX like N'%" + tenNSX + "%'\r\n"
					+ "								and LoaiThuoc.tenLoaiThuoc like N'%" + tenLoai + "%'\r\n";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maThuoc = rs.getString(1);
				String tenThuoc = rs.getString(2);
				float giaBan = rs.getFloat(3);
				int soLuong = rs.getInt(4);
				String moTa = rs.getString(5);
				String maNSX = rs.getString(6);
				String maLoai = rs.getString(7);
				String maDV = rs.getString(8);
				String maQG = rs.getString(9);	
				Thuoc t = new Thuoc(maThuoc, tenThuoc, giaBan, soLuong, moTa, maNSX, maLoai, maDV, maQG);
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsThuoc;
	}
//
//	public boolean banThuoc(String maThuoc, int soLuong) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("declare @soLuong int \r\n"
//					+ "set  @soLuong = (select SoLuong from Thuoc where maThuoc like ?)\r\n"
//					+ "update Thuoc set SoLuong = @soLuong - " + soLuong + " where maThuoc like ?");
//			stmt.setString(1, maThuoc);
//			stmt.setString(2, maThuoc);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
//	}
//
//	public String tuDongLayMa() {
//		String maThuoc = "";
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			String sql = "declare @ma char(5),@max int\r\n"
//					+ "set @ma = RIGHT((select MAX(maThuoc) from Thuoc),3)\r\n"
//					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'T' + cast(@max as char(3))\r\n"
//					+ "select @ma";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String ma = rs.getString(1);
//				maThuoc = ma;
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return maThuoc;
//	}

	public double layGiaBan(String maThuoc) {
		float giaBan = 0;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select [dbo].[inMaThuoc_GiaBan]('" + maThuoc + "')";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				float gb = rs.getFloat(1);
				giaBan = gb;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return giaBan;
	}
}

