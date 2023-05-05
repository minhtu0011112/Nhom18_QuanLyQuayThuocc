package class_entity;

public class DonViTinh {
	private String maDV,tenDonVi;

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public DonViTinh(String maDV, String tenDonVi) {
		super();
		this.maDV = maDV;
		this.tenDonVi = tenDonVi;
	}

	public DonViTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDV == null) ? 0 : maDV.hashCode());
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
		DonViTinh other = (DonViTinh) obj;
		if (maDV == null) {
			if (other.maDV != null)
				return false;
		} else if (!maDV.equals(other.maDV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonViTinh [maDV=" + maDV + ", tenDonVi=" + tenDonVi + "]";
	}
}
