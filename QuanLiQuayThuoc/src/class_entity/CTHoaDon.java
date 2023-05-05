package class_entity;

public class CTHoaDon {
	String maHD;
	String maThuoc;
	int soLuong;
	String hinhThucBan;
	float tongCong;
	int chietKhau;
	float khachDua;
	float traKhach;
	int trangThai;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public String getHinhThucBan() {
		return hinhThucBan;
	}
	public void setHinhThucBan(String hinhThucBan) {
		this.hinhThucBan = hinhThucBan;
	}
	public float getTongCong() {
		return tongCong;
	}
	public void setTongCong(float tongCong) {
		this.tongCong = tongCong;
	}
	public int getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(int chietKhau) {
		this.chietKhau = chietKhau;
	}
	public float getKhachDua() {
		return khachDua;
	}
	public void setKhachDua(float khachDua) {
		this.khachDua = khachDua;
	}
	public float getTraKhach() {
		return traKhach;
	}
	public void setTraKhach(float traKhach) {
		this.traKhach = traKhach;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public CTHoaDon(String maHD, String maThuoc, int soLuong, String hinhThucBan, float tongCong, int chietKhau,
			float khachDua, float traKhach, int trangThai) {
		super();
		setMaHD(maHD);
		setMaThuoc(maThuoc);
		setSoLuong(soLuong);
		setHinhThucBan(hinhThucBan);
		setTongCong(tongCong);
		setChietKhau(chietKhau);
		setKhachDua(khachDua);
		setTraKhach(traKhach);
		setTrangThai(trangThai);
	}
	public CTHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

}
