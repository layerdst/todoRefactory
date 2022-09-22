package db;

import java.util.Map;

public interface MakeSql {
    default String setSql(Map<String, Object> sqlParam, String sql) {
        String tempSql = sql;
        sqlParam.entrySet().stream().forEach(
                v -> {
                    System.out.println(v.getKey() + " : " + v.getValue());
                    tempSql=tempSql.replace(":" + v.getKey(), typeValue(v.getValue()));
                }
        );

        System.out.println(tempSql);
        return tempSql;
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
