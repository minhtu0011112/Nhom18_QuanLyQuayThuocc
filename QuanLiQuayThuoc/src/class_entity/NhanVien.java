package class_entity;

import java.sql.Date;

public class NhanVien {
	private String maNV, tenNV, chuVu, gioiTinh;
	private Date ngaySinh, ngayLamViec;
	private String cMND, diaChi, quanHuyen, tinhTP, email, sdt;
	private int tinhTrang;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}

	public String getMaNV() {
		return maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getChuVu() {
		return chuVu;
	}

	public void setChuVu(String chuVu) {
		this.chuVu = chuVu;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Date getNgayLamViec() {
		return ngayLamViec;
	}

	public void setNgayLamViec(Date ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
	}

	public String getcMND() {
		return cMND;
	}

	public void setcMND(String cMND) {
		this.cMND = cMND;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getTinhTP() {
		return tinhTP;
	}

	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public NhanVien(String maNV, String tenNV, String chuVu, String gioiTinh, Date ngaySinh, Date ngayLamViec,
			String cMND, String diaChi, String quanHuyen, String tinhTP, String email, String sdt, int tinhTrang) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.chuVu = chuVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayLamViec = ngayLamViec;
		this.cMND = cMND;
		this.diaChi = diaChi;
		this.quanHuyen = quanHuyen;
		this.tinhTP = tinhTP;
		this.email = email;
		this.sdt = sdt;
		this.tinhTrang = tinhTrang;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}


}
