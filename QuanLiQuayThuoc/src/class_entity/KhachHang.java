package class_entity;

import java.sql.Date;

public class KhachHang {
	private String maKH;
	private String maLoaiKH;
	private String tenKH;
	private String gioiTinh;
	private java.util.Date ngaySinh;
	private String soCMND;
	private String diaChi;
	private String Tinh_TP;
	private String Quan_Huyen;
	private String sdt;
	private String ghiChu;
	
public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaLoaiKH() {
		return maLoaiKH;
	}

	public void setMaLoaiKH(String maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public java.util.Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(java.util.Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTinh_TP() {
		return Tinh_TP;
	}

	public void setTinh_TP(String tinh_TP) {
		Tinh_TP = tinh_TP;
	}

	public String getQuan_Huyen() {
		return Quan_Huyen;
	}

	public void setQuan_Huyen(String quan_Huyen) {
		Quan_Huyen = quan_Huyen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	

	public KhachHang(String maKH, String maLoaiKH, String tenKH, String gioiTinh, java.util.Date ngaySinh,
			String soCMND, String diaChi, String tinh_TP, String quan_Huyen, String sdt, String ghiChu) {
		super();
		setMaKH(maKH);
		setMaLoaiKH(maLoaiKH);
		setTenKH(tenKH);
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
		setSoCMND(soCMND);
		setDiaChi(diaChi);
		setTinh_TP(tinh_TP);
		setQuan_Huyen(quan_Huyen);
		setSdt(sdt);
		setGhiChu(ghiChu);
		
	}


	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
