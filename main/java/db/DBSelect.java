package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.TodoDto;




public class DBSelect {

	List<TodoDto> list =new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//	public List<TodoDao> getTodos() {
//		try {
//
//			conn=DriverManager.getConnection(dbUrl,dbUser,pw);
//
//			String sql="select * from todo";
//			pstmt=conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				long id = rs.getLong("id");
//				String userName =rs.getString("username");
//				String description = rs.getString("description");
//				int stage = rs.getInt("stage");
//				int priority = rs.getInt("priority");
//				Timestamp regDateTime = rs.getTimestamp("regDate");
//				TodoDao dao = new TodoDao(id, userName, description, stage, priority, regDateTime);
//				list.add(dao);
//			}
//
//		}catch(CustomException e) {
//			e.printStackTrace();
//		}finally {
//			if(rs !=null) {
//				try {
//					rs.close();
//				}catch (CustomException e) {
//					e.printStackTrace();
//				}
//			}
//
//			if(pstmt !=null) {
//				try {
//					pstmt.close();
//				}catch (CustomException e) {
//					e.printStackTrace();
//				}
//			}
//
//			if(conn !=null) {
//				try {
//					conn.close();
//				}catch (CustomException e) {
//					e.printStackTrace();
//
//				}
//			}
//
//		}
//		return list;
//	}

}
