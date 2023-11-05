package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.taiKhoan;

public class taiKhoanDAO implements IDataAccess<taiKhoan> {

	@Override
	public boolean insert(taiKhoan t) {
		Connection con = JDBCUtil.getConnection();
		
		try {
			String sql = "INSERT INTO `dbmangxahoi`.`taikhoan` (`taiKhoan`, `matKhau`, `hoTen`, `diaChi`, `email`, `soDienThoai`, `gioiTinh`) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getTaiKhoan());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getHoTen());			
			st.setString(4, t.getDiaChi());			
			st.setString(5, t.getEmail());			
			st.setString(6, t.getSoDienThoai());			
			st.setBoolean(7, t.isGioiTinh());	
			
			st.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeConnection(con);
		return false;
	}

	@Override
	public boolean delete(taiKhoan t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(taiKhoan t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public taiKhoan selectById(int id) {
		taiKhoan found = null;
		Connection con = JDBCUtil.getConnection();

		try {

			String sql = "SELECT * FROM taikhoan WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				found = new taiKhoan(rs.getInt("id"), rs.getString("taiKhoan"), rs.getString("anhDaiDien"), rs.getString("hoTen"),
									 rs.getBoolean("gioiTinh"), rs.getString("diaChi"), 
									 rs.getString("email"), rs.getString("soDienThoai"), rs.getString("status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeConnection(con);
		return found;
	}
	public taiKhoan selectByUserNamePassword(String username, String password) {
		taiKhoan found = null;
		Connection con = JDBCUtil.getConnection();

		try {

			String sql = "SELECT * FROM taikhoan WHERE taiKhoan = ? AND matKhau = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				found = new taiKhoan(rs.getInt("id"), rs.getString("taiKhoan"), rs.getString("anhDaiDien"), rs.getString("hoTen"),
						 rs.getBoolean("gioiTinh"), rs.getString("diaChi"), 
						 rs.getString("email"), rs.getString("soDienThoai"), rs.getString("status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeConnection(con);
		return found;
	}

	@Override
	public ArrayList<taiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
