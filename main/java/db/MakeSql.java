package db;

import java.util.Map;

public interface MakeSql {
    default String setSql(Map<String, String> sqlParam, String sql) {
        return paramInputSql(sqlParam, sql);
    }

    private String paramInputSql(Map<String, String> sqlParam, String sql) {
        String tempSql = sql;
        for(Map.Entry entry: sqlParam.entrySet()){
            tempSql = tempSql.replace(":"+entry.getKey().toString(),typeValue(entry.getValue().toString()));
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
}
