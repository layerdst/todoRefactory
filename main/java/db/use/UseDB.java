package db.use;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UseDB extends DBUtil {

    int insert(String sql, Map<String, String> param) throws SQLException;
    <T> List<T> select(Class<T> t, String sql) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;
    int update( String sql, Map<String, String> param) throws SQLException;




}
