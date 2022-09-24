package db;

import dto.TodoDto;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UseDBImpl implements UseDB{


    private final DBConnection dbconn = DBConnection.getInstance();
    private ResultSet rs = null;


    @Override
    public int insert(String sql, Map<String, String> param) throws SQLException {
        int count = 0;
        count = dbconn.setParamSql(setSql(param, sql)).executeUpdate();
        return count;
    }

    @Override
    public <T> List<T> select(Class<T> t, String sql) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        ResultSet resultSet = dbconn.setParamSql(sql).executeQuery();
        List<T> selectList = getSelectList(t, resultSet);
        return selectList;
    }

    @Override
    public <T> List<T> select(Class<T> t,Map<String, String> param, String sql) {
       return null;
    }

    @Override
    public <T> T selectOne(Map<String, String> param, String sql){
        return null;
    }

    @Override
    public int update(Map<String, String> param, String sql) throws SQLException {
        int count = 0;
        count = dbconn.setParamSql(setSql(param, sql)).executeUpdate();
        return count;
    }





}
