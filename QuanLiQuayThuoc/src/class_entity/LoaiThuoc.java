package class_entity;

public class LoaiThuoc {
	private String maLoai,tenLoaiThuoc;

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoaiThuoc() {
		return tenLoaiThuoc;
	}

	public void setTenLoaiThuoc(String tenLoaiThuoc) {
		this.tenLoaiThuoc = tenLoaiThuoc;
	}

	public LoaiThuoc(String maLoai, String tenLoaiThuoc) {
		super();
		this.maLoai = maLoai;
		this.tenLoaiThuoc = tenLoaiThuoc;
	}

	public LoaiThuoc() {
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
		LoaiThuoc other = (LoaiThuoc) obj;
		if (maLoai == null) {
			if (other.maLoai != null)
				return false;
		} else if (!maLoai.equals(other.maLoai))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoaiThuoc [maLoai=" + maLoai + ", tenNganhHang=" + tenLoaiThuoc + "]";
	}
	
	
}
