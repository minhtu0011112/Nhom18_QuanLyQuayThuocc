package class_entity;

public class NhaCungCap1 {
	private int maNCC;
	private String tenNCC;
	private String tenNguoiDD;
	private String diaChi;
	private String Tinh_TP;
	private String Quan_Huyen;
	private String sdt;
	private String fax;
	private String mail;
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
	public int getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(int maNCC) {
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
	public NhaCungCap1(int maNCC, String tenNCC, String tenNguoiDD, String diaChi, String tinh_TP, String quan_Huyen,
			String sdt, String fax, String mail) {
		super();
		setMaNCC(maNCC);
		setTenNCC(tenNCC);
		setTenNguoiDD(tenNguoiDD);
		setDiaChi(diaChi);
		setTinh_TP(tinh_TP);
		setQuan_Huyen(quan_Huyen);
		setSdt(sdt);
		setFax(fax);
		setMail(mail);
	}
	public NhaCungCap1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
