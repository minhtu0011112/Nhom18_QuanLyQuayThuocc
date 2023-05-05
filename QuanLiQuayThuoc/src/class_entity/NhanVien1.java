package class_entity;

import java.util.Date;

public class NhanVien1 {
	private int maVN;
	private String hoNV;
	private String tenNV;
	private Date ngaySinh;
	private String diaChi;
	private String GioiTinh;
	private String sDT;
	private String diaChiMail;
	private Date ngayVaoLam;
	private int quanLi;
	public int getMaVN() {
		return maVN;
	}
	public void setMaVN(int maVN) {
		this.maVN = maVN;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.GioiTinh = gioiTinh;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getDiaChiMail() {
		return diaChiMail;
	}
	public void setDiaChiMail(String diaChiMail) {
		this.diaChiMail = diaChiMail;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public int getQuanLi() {
		return quanLi;
	}
	public void setQuanLi(int quanLi) {
		this.quanLi = quanLi;
	}
	public NhanVien1(int maVN, String hoNV, String tenNV, Date ngaySinh, String diaChi, String gioiTinh, String sDT,
			String diaChiMail, Date ngayVaoLam, int quanLi) {
		super();
		this.maVN = maVN;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.GioiTinh = gioiTinh;
		this.sDT = sDT;
		this.diaChiMail = diaChiMail;
		this.ngayVaoLam = ngayVaoLam;
		this.quanLi = quanLi;
	}
	public NhanVien1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
