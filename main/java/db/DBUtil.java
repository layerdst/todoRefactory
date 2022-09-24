package db;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface DBUtil {
    default String setSql(Map<String, String> sqlParam, String sql) {
        return paramInputSql(sqlParam, sql);
    }


    default  <T> List<T> getSelectList(Class<T> t, ResultSet rs) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        List<T> dtos = new ArrayList<>();
        Class classDto = t;
        Field[] fields = classDto.getFields();
        Map<String, Object> tempMap = new LinkedHashMap<>();

        for(Field f : fields){
            String fieldName = f.getName();
            Class<?> type = f.getType();
            tempMap.put(fieldName, type);
        }

        while(rs.next()){
            Constructor<T> cs = t.getConstructor();
            T temp = cs.newInstance();
            for(Map.Entry<String, Object> rsTempMap : tempMap.entrySet()) {
                setMethod(
                        classDto,
                        changeMethodName(rsTempMap.getKey()),
                        (Class<?>)rsTempMap.getValue(),
                        temp,
                        changeType(rs,rsTempMap.getValue().toString(), rsTempMap.getKey()));
            }
            dtos.add((T) temp);
        }
        return dtos;
    }


    private String paramInputSql(Map<String, String> sqlParam, String sql) {
        String tempSql = sql;

        for(Map.Entry entry: sqlParam.entrySet()){
            String key = entry.getKey().toString();
            String value =typeValue(entry.getValue().toString());
            tempSql = tempSql.replace(":"+key, value);
        }
        return tempSql;
    }

    private String typeValue(String obj){
        String temp = obj;
        char check;
        if(temp.equals("")){
            return "";
        }

        for(int i=0; i <temp.length();i++) {
            check = temp.charAt(i);
            if (check < 48 || check > 58) {
                return "'" + temp + "'";
            }
        }
        return temp;
    }
    private <T, K, V> Object changeType(ResultSet rs, String type,String name) throws SQLException {
        Object obj=null;
        switch (type){
            case "long" : obj = rs.getInt(name); break;
            case "class java.lang.String" : obj =rs.getString(name); break;
            case "int" : obj =rs.getInt(name);break;
            case "class java.sql.Date" : obj =rs.getDate(name); break;
        }
        return obj;
    }

    private String changeMethodName(String fieldName){
        return "set"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    private <CL, T> void setMethod( Class<CL> CL, String methodName, Class<?> referenceClass, T dto, Object data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CL.getMethod(methodName, referenceClass).invoke(dto,new Object[]{data});
    }





}
