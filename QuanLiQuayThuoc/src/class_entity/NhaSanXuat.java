package class_entity;

public class NhaSanXuat {
	private String maNSX,tenNSX,sDT,fax,email;

	public String getMaNSX() {
		return maNSX;
	}

	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}

	public String getTenNSX() {
		return tenNSX;
	}

	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NhaSanXuat(String maNSX, String tenNSX, String sDT, String fax, String email) {
		super();
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
		this.sDT = sDT;
		this.fax = fax;
		this.email = email;
	}

	public NhaSanXuat() {
		super();
		// TODO Auto-generated constructor stub
	}

}
