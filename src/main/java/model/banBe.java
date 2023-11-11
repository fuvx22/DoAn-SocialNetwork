package model;

public class banBe {
	private int id;
	private int taiKhoan_id;
	private taiKhoan banBe;
	
	public banBe(int id, int taiKhoan_id, taiKhoan banBe) {
		super();
		this.id = id;
		this.taiKhoan_id = taiKhoan_id;
		this.banBe = banBe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaiKhoan_id() {
		return taiKhoan_id;
	}

	public void setTaiKhoan_id(int taiKhoan_id) {
		this.taiKhoan_id = taiKhoan_id;
	}

	public taiKhoan getBanBe() {
		return banBe;
	}

	public void setBanBe(taiKhoan banBe) {
		this.banBe = banBe;
	}
	
	
}
