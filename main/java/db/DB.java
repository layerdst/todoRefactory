package db;


import dao.TodoDto;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static db.DBInfo.*;

public class DB {

    public Connection conn;
    public PreparedStatement psmt;
    public ResultSet rs;

    List<TodoDto> todos = new ArrayList<>();

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

    Class getSelectList(Class dto) throws SQLException {
        Field[] dtoFields = dto.getFields();

        for(Field f : dtoFields){



            TodoDto dto = new TodoDto(
        }

        Map<String, String> dtoMap = Arrays.stream(dtoFields)
            .collect(
                Collectors.toMap(
                    v1 -> v1.getName(),
                    v2 -> v2.getType().getTypeName()
                )
        );



        while(rs.next()){


        }
        return null;
    }

    Object changeType(String type, String args) throws SQLException {
        Object temp = null;
        switch (type){
            case "int" : temp = rs.getInt(args); break;
            case "long" : temp = rs.getLong(args); break;
            case "java.lang.String" : temp = rs.getString(args); break;
            case "TimeStamp" : temp = rs.getDate(args); break;
            default: temp = null; break;
        }
        return temp;
    }

    DB set() throws SQLException {
        while(rs.next()){
            long id = rs.getLong("id");
				String userName =rs.getString("username");
				String description = rs.getString("description");
				int stage = rs.getInt("stage");
				int priority = rs.getInt("priority");
				Date regDateTime = rs.getDate("regDate");
				TodoDto dao = new TodoDto(id, userName, description, stage, priority, regDateTime);
				todos.add(dao);
        }
        return this;
    }

    List<TodoDto> getTodos(){
        return todos;
    }



}
