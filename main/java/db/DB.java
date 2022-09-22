package db;


import dao.TodoDto;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

import static db.DBInfo.*;

public class DB {

//    private final DBConnections conn;
//    private final PreparedStatement psmt;
//    private final ResultSet rs;
//
//    public DB(DBConnections conn) throws SQLException {
//        this.conn = conn;
//
//    }
//
//    List<TodoDto> todos = new ArrayList<>();
//
//    DB getConnections() throws SQLException{
//        conn =
//        return this;
//    }
//
//    DB getPrepareStatement(String sql) throws SQLException {
//        conn.prepareStatement(sql);
//        return this;
//    }
//
//    DB getResultQuery() throws SQLException {
//        psmt.executeQuery();
//        return this;
//    }
//
//    List<TodoDto> getSelectList(Class dto) throws SQLException {
//
//        Field[] dtoFields = dto.getFields();
//
////        Map<String, String> collect = Arrays.stream(dtoFields).collect(
////                Collectors.
////        );
////
////        Collectors<TodoDto, ?, List<TodoDto>> todoDtoLinkedList = Collectors.of(List::new, List::add,())
////
////
////        while(rs.next()){
////
////        }
//
//        return null;
//    }
//
//    Object changeType(String type, String args) throws SQLException {
//        Object temp;
//        switch (type){
//            case "int" : temp = rs.getInt(args); break;
//            case "long" : temp = rs.getLong(args); break;
//            case "java.lang.String" : temp = rs.getString(args); break;
//            case "TimeStamp" : temp = rs.getDate(args); break;
//            default: temp = null; break;
//        }
//        return temp;
//    }
//
//    DB set() throws SQLException {
//        while(rs.next()){
//            long id = rs.getLong("id");
//				String userName =rs.getString("username");
//				String description = rs.getString("description");
//				int stage = rs.getInt("stage");
//				int priority = rs.getInt("priority");
//				Date regDateTime = rs.getDate("regDate");
//				TodoDto dao = new TodoDto(id, userName, description, stage, priority, regDateTime);
//				todos.add(dao);
//        }
//        return this;
//    }
//
//    List<TodoDto> getTodos(){
//        return todos;
//    }
//


}
