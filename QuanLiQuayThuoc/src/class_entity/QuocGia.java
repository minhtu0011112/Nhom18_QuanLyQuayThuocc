package class_entity;

public class QuocGia {
	private String maQG,tenQuocGia;

	public String getMaQG() {
		return maQG;
	}

	public void setMaQG(String maQG) {
		this.maQG = maQG;
	}

	public String getTenQuocGia() {
		return tenQuocGia;
	}

	public void setTenQuocGia(String tenQuocGia) {
		this.tenQuocGia = tenQuocGia;
	}

	public QuocGia(String maQG, String tenQuocGia) {
		super();
		this.maQG = maQG;
		this.tenQuocGia = tenQuocGia;
	}

	public QuocGia() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maQG == null) ? 0 : maQG.hashCode());
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
		QuocGia other = (QuocGia) obj;
		if (maQG == null) {
			if (other.maQG != null)
				return false;
		} else if (!maQG.equals(other.maQG))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuocGia [maQG=" + maQG + ", tenQuocGia=" + tenQuocGia + "]";
	}
	
}
