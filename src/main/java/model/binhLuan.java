package model;

import java.util.Date;

public class binhLuan {
	private int id;
	private int baiViet_id;
	private taiKhoan taiKhoan;
	private String noiDung;
	private Date ngayTao;
	private int binhLuanCha;
	
	public binhLuan(int id, int baiViet_id, model.taiKhoan taiKhoan, String noiDung, Date ngayTao, int binhLuanCha) {
		super();
		this.id = id;
		this.baiViet_id = baiViet_id;
		this.taiKhoan = taiKhoan;
		this.noiDung = noiDung;
		this.ngayTao = ngayTao;
		this.binhLuanCha = binhLuanCha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaiViet_id() {
		return baiViet_id;
	}

	public void setBaiViet_id(int baiViet_id) {
		this.baiViet_id = baiViet_id;
	}

	public taiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(taiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getBinhLuanCha() {
		return binhLuanCha;
	}

	public void setBinhLuanCha(int binhLuanCha) {
		this.binhLuanCha = binhLuanCha;
	}
	
	
}	
