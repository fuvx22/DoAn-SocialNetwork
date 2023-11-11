package model;

import java.util.Date;

public class baiViet {
	private int id;
	private int taiKhoan_id;
	private String noiDung;
	private String hinhAnh;
	private Date ngayDang;
	
	public baiViet(int id, int taiKhoan_id, String noiDung, String hinhAnh, Date ngayDang) {
		super();
		this.id = id;
		this.taiKhoan_id = taiKhoan_id;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
		this.ngayDang = ngayDang;
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

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	
	
}
