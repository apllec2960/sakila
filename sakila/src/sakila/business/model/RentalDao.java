package sakila.business.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.db.DBHelper;

public class RentalDao {
	//렌탈 테이블에 행의 수를 구하는 메소드
	public int selectRentalCount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		String sql = "SELECT COUNT(*) FROM rental";
		int count =0;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs =stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBHelper.close(rs, stmt, conn);
			}
		return count;
	}
}
