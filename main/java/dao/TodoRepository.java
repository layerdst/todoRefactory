package dao;

import db.use.UseDB;
import db.use.UseDBImpl;
import dto.TodoDto;
import static db.source.DBSql.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class TodoRepository {
    private final UseDB useDB;

    public TodoRepository(){
        this.useDB = new UseDBImpl();
    }

    public List<TodoDto> getAllTodos() throws Exception{
        return useDB.select(TodoDto.class, GET_ALL_TODO);
    }

    public int insertTodo(Map<String, String> param) throws SQLException {
        return useDB.insert(INSERT_TODO,param);
    }

    public int updateTodo(Map<String, String> param) throws SQLException {
        return useDB.update(UPDATE_TODO, param);
    }
}
