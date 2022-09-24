package db;

public class DBSql {
    protected static String GET_ALL_TODO = "select * from todo";
    protected static String UPDATE_TODO = "update todo \n" +
                                            "\tset stage = case \n" +
                                            "\t\twhen stage = 1 then 2\n" +
                                            "        when stage = 2 then 3\n" +
                                            "        else 3\n" +
                                            "        end\n" +
                                            "\twhere id = :id ;";

    protected static String INSERT_TODO = "insert into todo (username, description, priority) values( :username , :description , :priority )";
}
