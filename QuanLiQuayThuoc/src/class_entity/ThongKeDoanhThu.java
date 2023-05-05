package class_entity;

import java.sql.Date;

public class ThongKeDoanhThu {
	private Date ngayLapHD;
	private int tongSoHoaDon;
	private float tongSoTienBan;
	
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public int getTongSoHoaDon() {
		return tongSoHoaDon;
	}
	public void setTongSoHoaDon(int tongSoHoaDon) {
		this.tongSoHoaDon = tongSoHoaDon;
	}
	public float getTongSoTienBan() {
		return tongSoTienBan;
	}
	public void setTongSoTienBan(float tongSoTienBan) {
		this.tongSoTienBan = tongSoTienBan;
	}
	public ThongKeDoanhThu(Date ngayLapHD, int tongSoHoaDon, float tongSoTienBan) {
		super();
		this.ngayLapHD = ngayLapHD;
		this.tongSoHoaDon = tongSoHoaDon;
		this.tongSoTienBan = tongSoTienBan;
	}
	public ThongKeDoanhThu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
