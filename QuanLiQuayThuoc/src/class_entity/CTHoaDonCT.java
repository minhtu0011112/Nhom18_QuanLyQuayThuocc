package class_entity;

import java.sql.Date;

public class CTHoaDonCT {
	private String maHD;
	private String tenKH;
	private int soLuong;
	private float tongCong;
	private Date ngayLapHD;
	private String hoTenNV;
	private int trangThai;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getTongCong() {
		return tongCong;
	}
	public void setTongCong(float tongCong) {
		this.tongCong = tongCong;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public String getHoTenNV() {
		return hoTenNV;
	}
	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public CTHoaDonCT(String maHD, String tenKH, int soLuong, float tongCong, Date ngayLapHD, String hoTenNV,
			int trangThai) {
		super();
		setMaHD(maHD);
		setTenKH(tenKH);
		setSoLuong(soLuong);
		setTongCong(tongCong);
		setNgayLapHD(ngayLapHD);
		setHoTenNV(hoTenNV);
		setTrangThai(trangThai);
	}
	public CTHoaDonCT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
