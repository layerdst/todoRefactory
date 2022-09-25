package db;

import db.use.UseDB;
import db.use.UseDBImpl;
import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UseDBImplTest extends TestCase {



    public static void main(String[] args) throws SQLException {
        UseDB us = new UseDBImpl();
        Map<String, String > temp = new HashMap<>();
        temp.put("username", "test");
        temp.put("description", "java");
        temp.put("priority", "1");
        System.out.println(us.insert("insert into todo (username, description, priority) values( :username , :description , :priority )",temp));
    }
}