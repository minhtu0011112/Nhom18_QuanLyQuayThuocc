package class_entity;

public class DangNhap {
	private String maTK,matKhau;
	private int quanLy;

	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getQuanLy() {
		return quanLy;
	}
	public void setQuanLy(int quanLy) {
		this.quanLy = quanLy;
	}
	public DangNhap(String maTK, String matKhau, int quanLy) {
		super();
		this.maTK = maTK;
		this.matKhau = matKhau;
		this.quanLy = quanLy;
	}
	public DangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTK == null) ? 0 : maTK.hashCode());
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
		DangNhap other = (DangNhap) obj;
		if (maTK == null) {
			if (other.maTK != null)
				return false;
		} else if (!maTK.equals(other.maTK))
			return false;
		return true;
	}
	
}
