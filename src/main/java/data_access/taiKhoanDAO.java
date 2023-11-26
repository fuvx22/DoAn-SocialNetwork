package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.jdbc.JdbcConnection;

import model.taiKhoan;

public class taiKhoanDAO implements IDataAccess<taiKhoan> {

	
	public boolean checkTaiKhoanIfExist(String taikhoan) {
		Connection connection = JDBCUtil.getConnection();
		
		try {
			String sql = "SELECT * FROM taikhoan WHERE taiKhoan = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, taikhoan);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				return false;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	@Override
	public boolean insert(taiKhoan t) {
		Connection con = JDBCUtil.getConnection();
		
		try {
			String sql = "INSERT INTO `dbmangxahoi`.`taikhoan` (`taiKhoan`, `matKhau`,`anhDaiDien`, `hoTen`, `diaChi`, `email`, `soDienThoai`, `gioiTinh`) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getTaiKhoan());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getAnhDaiDien().trim());
			st.setString(4, t.getHoTen());			
			st.setString(5, t.getDiaChi());			
			st.setString(6, t.getEmail());			
			st.setString(7, t.getSoDienThoai());			
			st.setBoolean(8, t.isGioiTinh());	
			
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
		
		return false;
	}

	@Override
	public boolean update(taiKhoan t) {
		Connection con = JDBCUtil.getConnection();
		
		try {
			String sql = "UPDATE `dbmangxahoi`.`taikhoan` SET `taiKhoan`=?, `matKhau`=?, "
					+ "`anhDaiDien`=?, `hoTen`=?, `diaChi`=?, `email`=?, `soDienThoai`=?, `gioiTinh`=? "
					+ "WHERE `id`=?;";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getTaiKhoan());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getAnhDaiDien().trim());
			st.setString(4, t.getHoTen());			
			st.setString(5, t.getDiaChi());			
			st.setString(6, t.getEmail());			
			st.setString(7, t.getSoDienThoai());			
			st.setBoolean(8, t.isGioiTinh());
			st.setInt(9, t.getId());
			
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
		ArrayList<taiKhoan> listTaiKhoans = new ArrayList<taiKhoan>();;
		Connection connection = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM taikhoan";
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				//int id = rs.getInt("id");
				String taiKhoan = rs.getString("taiKhoan");
				//String matKhau = rs.getString("matKhau");
				//String anhDaiDien = rs.getString("anhDaiDien");
				//String hoTen = rs.getString("hoTen");
				//String diaChi = rs.getString("diaChi");
				//String email = rs.getString("diaChi");
				//String soDienThoai = rs.getString("soDienThoai");
				//String status = rs.getString("status");
				//boolean gioiTinh = rs.getBoolean("gioiTnh");
				
				taiKhoan tk = new taiKhoan(taiKhoan);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	
	
	public static void main(String[] args) {
		 String yourString = "/DoAn-SocialNetwork/images/avatar-resource/default-avatar.png";

	        if (containsSpecialCharacter(yourString)) {
	            System.out.println("Chuỗi có ký tự đặc biệt.");
	        } else {
	            System.out.println("Chuỗi không có ký tự đặc biệt.");
	        }
	    }

	    public static boolean containsSpecialCharacter(String str) {
	        // Sử dụng regex để kiểm tra xem có ký tự đặc biệt nào trong chuỗi không
	        return !str.matches("[a-zA-Z0-9-_./]+");
	    }
		
		
		
	
}
