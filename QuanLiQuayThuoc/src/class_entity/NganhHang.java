package class_entity;

public class NganhHang {
	private String maLoai,tenNganhHang;

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenNganhHang() {
		return tenNganhHang;
	}

	public void setTenNganhHang(String tenNganhHang) {
		this.tenNganhHang = tenNganhHang;
	}

	public NganhHang(String maLoai, String tenNganhHang) {
		super();
		this.maLoai = maLoai;
		this.tenNganhHang = tenNganhHang;
	}

	public NganhHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoai == null) ? 0 : maLoai.hashCode());
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
		NganhHang other = (NganhHang) obj;
		if (maLoai == null) {
			if (other.maLoai != null)
				return false;
		} else if (!maLoai.equals(other.maLoai))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NganhHang [maLoai=" + maLoai + ", tenNganhHang=" + tenNganhHang + "]";
	}
	
	
}
