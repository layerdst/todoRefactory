package db;


import dao.TodoDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static db.DBInfo.*;

public class DB {

    public Connection conn;
    public PreparedStatement psmt;
    public ResultSet rs;

    List<TodoDao> todos = new ArrayList<>();

    DB getConnections() throws SQLException{
        conn = DriverManager.getConnection(DB_ADDR, DB_USER, DB_PW);
        return this;
    }

    DB getPrepareStatement(String sql) throws SQLException {
        psmt = conn.prepareStatement(sql);
        return this;
    }

    DB getResultQuery() throws SQLException {
        rs = psmt.executeQuery();
        return this;
    }

    DB set() throws SQLException {
        while(rs.next()){
            long id = rs.getLong("id");
				String userName =rs.getString("username");
				String description = rs.getString("description");
				int stage = rs.getInt("stage");
				int priority = rs.getInt("priority");
				Timestamp regDateTime = rs.getTimestamp("regDate");
				TodoDao dao = new TodoDao(id, userName, description, stage, priority, regDateTime);
				todos.add(dao);
        }
        return this;
    }

    List<TodoDao> getTodos(){
        return todos;
    }



}
