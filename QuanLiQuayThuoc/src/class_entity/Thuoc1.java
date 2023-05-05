package class_entity;

public class Thuoc1 {
	//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG,HoatChat
	private String maThuoc,tenThuoc,moTa,nhaSanXuat,loaiThuoc,donViTinh,quocGia,hoatChat;
	private float giaBan;
	private int soLuong;
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
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}
	public String getLoaiThuoc() {
		return loaiThuoc;
	}
	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public String getHoatChat() {
		return hoatChat;
	}
	public void setHoatChat(String hoatChat) {
		this.hoatChat = hoatChat;
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
	public Thuoc1(String maThuoc, String tenThuoc, String moTa, String nhaSanXuat, String loaiThuoc, String donViTinh,
			String quocGia, String hoatChat, float giaBan, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.moTa = moTa;
		this.nhaSanXuat = nhaSanXuat;
		this.loaiThuoc = loaiThuoc;
		this.donViTinh = donViTinh;
		this.quocGia = quocGia;
		this.hoatChat = hoatChat;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}
	public Thuoc1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc1 other = (Thuoc1) obj;
		if (maThuoc == null) {
			if (other.maThuoc != null)
				return false;
		} else if (!maThuoc.equals(other.maThuoc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", moTa=" + moTa + ", nhaSanXuat=" + nhaSanXuat
				+ ", loaiThuoc=" + loaiThuoc + ", donViTinh=" + donViTinh + ", quocGia=" + quocGia + ", hoatChat="
				+ hoatChat + ", giaBan=" + giaBan + ", soLuong=" + soLuong + "]";
	}

}
