package class_entity;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String tenNguoiDD;
	private String diaChi;
	private String tinh_TP;
	private String quan_Huyen;
	private String sDT;
	private String fax;
	private String mail;
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getTenNguoiDD() {
		return tenNguoiDD;
	}
	public void setTenNguoiDD(String tenNguoiDD) {
		this.tenNguoiDD = tenNguoiDD;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTinh_TP() {
		return tinh_TP;
	}
	public void setTinh_TP(String tinh_TP) {
		this.tinh_TP = tinh_TP;
	}
	public String getQuan_Huyen() {
		return quan_Huyen;
	}
	public void setQuan_Huyen(String quan_Huyen) {
		this.quan_Huyen = quan_Huyen;
	}
	public String getSDT() {
		return sDT;
	}
	public void setSDT(String sDT) {
		this.sDT = sDT;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public NhaCungCap(String maNCC, String tenNCC, String tenNguoiDD, String diaChi, String tinh_TP, String quan_Huyen,
			String sDT, String fax, String mail) {
		super();
		setMaNCC(maNCC);
		setTenNCC(tenNCC);
		setTenNguoiDD(tenNguoiDD);
		setDiaChi(diaChi);
		setTinh_TP(tinh_TP);
		setQuan_Huyen(quan_Huyen);
		setSDT(sDT);
		setFax(fax);
		setMail(mail);
	}
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNCC == null) ? 0 : maNCC.hashCode());
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
		NhaCungCap other = (NhaCungCap) obj;
		if (maNCC == null) {
			if (other.maNCC != null)
				return false;
		} else if (!maNCC.equals(other.maNCC))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", tenNguoiDD=" + tenNguoiDD + ", diaChi=" + diaChi
				+ ", tinh_TP=" + tinh_TP + ", quan_Huyen=" + quan_Huyen + ", sDT=" + sDT + ", fax=" + fax + ", mail="
				+ mail + "]";
	}
	
}
