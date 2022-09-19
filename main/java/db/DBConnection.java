package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.spi.ImageReaderWriterSpi;
import javax.swing.ListModel;

import dao.TodoDao;




public class DBConnection {
	
	private static String dbUrl ="jdbc:mysql://localhost:3306/todo";
	private static String dbUser ="boostuser";
	private static String pw = "12345678";
	
	List<TodoDao> list =new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<TodoDao> getTodos() {
		try {

			conn=DriverManager.getConnection(dbUrl,dbUser,pw);
			
			String sql="select * from todo";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				long id = rs.getLong("id");
				String userName =rs.getString("username");
				String description = rs.getString("description");
				int stage = rs.getInt("stage");
				int priority = rs.getInt("priority");
				Timestamp regDateTime = rs.getTimestamp("regDate");
				TodoDao dao = new TodoDao(id, userName, description, stage, priority, regDateTime);
				list.add(dao);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt !=null) {
				try {
					pstmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn !=null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
			
				}
			}

		}
		return list;
	}

}
