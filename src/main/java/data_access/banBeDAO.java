package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.banBe;
import model.taiKhoan;

public class banBeDAO {
	
	public banBe getUserFriends(int id) {
		ArrayList<taiKhoan> listBanBe = new ArrayList<taiKhoan>();
		Connection connection = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT t.id, t.anhDaiDien, t.hoTen FROM taikhoan as t "
					+ "INNER JOIN banbe as b ON b.banbe_id = t.id "
					+ "WHERE b.taikhoan_id =? "
					+ "UNION "
					+ "SELECT t.id, t.anhDaiDien, t.hoTen FROM taikhoan as t "
					+ "INNER JOIN banbe as b ON b.taikhoan_id = t.id "
					+ "WHERE b.banbe_id = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.setInt(2, id);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				int tk_id = rs.getInt("id");
				String anhDaiDien = rs.getString("anhDaiDien");
				String hoTen = rs.getString("hoTen");
				
				listBanBe.add(new taiKhoan(tk_id, anhDaiDien, hoTen));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		
		return new banBe(id, listBanBe);
	}
	
}
