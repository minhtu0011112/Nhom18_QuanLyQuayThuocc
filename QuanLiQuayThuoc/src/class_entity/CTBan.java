package class_entity;

public class CTBan {
	private String maThuoc;
	private int soLuong;
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
	public CTBan(String maThuoc, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}
	public CTBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
