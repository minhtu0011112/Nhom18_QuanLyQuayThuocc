package class_entity;

public class Thuoc {
	//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG
	private String maThuoc,tenThuoc;
	private float giaBan;
	private int soLuong;
	private String moTa,maNSX,maLoai,maDV,maQG;
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getMaNSX() {
		return maNSX;
	}
	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getMaQG() {
		return maQG;
	}
	public void setMaQG(String maQG) {
		this.maQG = maQG;
	}
	public Thuoc(String maThuoc, String tenThuoc, float giaBan, int soLuong, String moTa, String maNSX, String maLoai,
			String maDV, String maQG) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.moTa = moTa;
		this.maNSX = maNSX;
		this.maLoai = maLoai;
		this.maDV = maDV;
		this.maQG = maQG;
	}
	public Thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
