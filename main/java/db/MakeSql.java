package db;

import java.sql.PreparedStatement;
import java.util.Map;
import java.util.stream.Collectors;

public interface MakeSql {
    default String setSql(Map<String, Object> sqlParam, String sql) {
        String tempSql = sql;
        for(Map.Entry entry:sqlParam.entrySet()){
            tempSql=tempSql.replace(":"+entry.getKey().toString(),typeValue(entry.getValue()));
        }
        return tempSql;
    }

    default void getSql(String key, String value){

    }
    default String typeValue(Object obj){
        String temp = obj.toString();
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
}
