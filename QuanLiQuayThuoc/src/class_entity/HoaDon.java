package class_entity;

import java.sql.Date;

public class HoaDon {
	String maHD;
	String maNV;
	String maKH;
	Date ngayLapHD;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public HoaDon(String maHD, String maNV, String maKH, Date ngayLapHD) {
		super();
		setMaHD(maHD);
		setMaNV(maNV);
		setMaKH(maKH);
		setNgayLapHD(ngayLapHD);
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maMV=" + maNV + ", maKH=" + maKH + ", ngayLapHD=" + ngayLapHD + "]";
	}
	
}
