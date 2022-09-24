package db;

import dto.TodoDto;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UseDB<T> extends MakeSql {

    int insert(String sql, Map<String, String> param) throws SQLException;
    <S> List<S> select(List<TodoDto> dtos, String sql) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
    <S> List<S> select(List<TodoDto> dtos, Map<String, String> param, String sql, T dto);
    T selectOne(Map<String, String> param, String sql,T dto);





}
