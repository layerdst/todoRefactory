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
        dbconn.closedConnection(dbconn.getConn(), dbconn.getPsmt(), null);
        return count;
    }

    @Override
    public <T> List<T> select(Class<T> t, String sql) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ResultSet resultSet = dbconn.setParamSql(sql).executeQuery();
        List<T> selectList = getSelectList(t, resultSet);
        dbconn.closedConnection(dbconn.getConn(), dbconn.getPsmt(), rs);
        return selectList;
    }

    @Override
    public int update(String sql, Map<String, String> param) throws SQLException {
        int count = 0;
        count = dbconn.setParamSql(setSql(param, sql)).executeUpdate();
        dbconn.closedConnection(dbconn.getConn(), dbconn.getPsmt(), null);
        return count;
    }

}
