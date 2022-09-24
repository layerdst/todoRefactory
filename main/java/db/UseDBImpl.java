package db;

import dto.TodoDto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UseDBImpl<T> implements UseDB<TodoDto> {

    private T todo;
    private final DBConnection dbconn = DBConnection.getInstance();
    private ResultSet rs = null;

    public T getTodo() {
        return todo;
    }

    public void setTodo(T todo) {
        this.todo = todo;
    }

    @Override
    public int insert(String sql, Map<String, String> param) throws SQLException {
        int count = 0;
        count = dbconn.setParamSql(setSql(param, sql)).executeUpdate();
        return count;
    }

    @Override
    public <T> List<T> select(List<TodoDto> dtos, String sql) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ResultSet resultSet = dbconn.setParamSql(sql).executeQuery();
        dtos = getSelectList(TodoDto.class, resultSet);
        return dtos;
    }

    @Override
    public <S, T> List<S> select(List<TodoDto> dtos, Map<String, String> param, String sql, T dto) {
       return null;
    }

    @Override
    public TodoDto selectOne(Map<String, String> param, String sql, TodoDto dto) {
        return null;
    }


    public <T, K, V> Object changeType(ResultSet rs, String type,String name) throws SQLException {
        Object obj=null;
        switch (type){
            case "long" : obj = rs.getInt(name); break;
            case "java.lang.String" : obj =rs.getString(name); break;
            case "int" : obj =rs.getInt(name);break;
            case "java.sql.Date" : obj =rs.getDate(name); break;
        }
        return obj;
    }

    public String changeMethodName(String fieldName){
        return "set"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }


    public Object setTypeClass(String type){
        Object obj=null;
        switch (type){
            case "long" : obj=long.class; break;
            case "java.lang.String" : obj= String.class; break;
            case "int" : obj=int.class; break;
            case "java.sql.Date" : obj = Date.class; break;
        }
        return obj;
    }

    public <CL, T, DTO, M, O> void setMethod(Class<CL> CL, Class<T> T, Class<DTO> dto,  String methodName, Object data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CL.getMethod(methodName, T).invoke(dto,new Object[]{data});
    }

    public <T> List<T> getSelectList(Class<TodoDto> dto, ResultSet rs) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<T> dtos = new ArrayList<>();
        Class<?> dtoClass = dto.getClass();
        Field[] fields = dtoClass.getFields();
        Map<String, Object> tempMap = new LinkedHashMap<>();

        for(Field f : fields){
            String fieldName = f.getName();
            Class<?> type = f.getType();
            tempMap.put(fieldName, type);
        }

        while(rs.next()){
            Class temp = dtoClass.getClass();
            for(Map.Entry<String, Object> rsTempMap : tempMap.entrySet()) {
                setMethod(dtoClass,
                        (Class<?>)rsTempMap.getValue(),
                        temp,
                        changeMethodName(rsTempMap.getKey()),
                        changeType(rs,rsTempMap.getValue().toString(), rsTempMap.getKey()));
            }
            dtos.add((T) temp);
        }

        return dtos;
    }



}
