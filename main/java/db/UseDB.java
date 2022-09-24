package db;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UseDB extends DBUtil {

    int insert(String sql, Map<String, String> param) throws SQLException;
    <T> List<T> select(Class<T> t, String sql) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;
    <T> List<T> select(Class<T> t, Map<String, String> param, String sql);
    <T> T selectOne(Map<String, String> param, String sql);
    int update(Map<String, String> param, String sql) throws SQLException;




}
