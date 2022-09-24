package db;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UseDBImplTest extends TestCase {



    public static void main(String[] args) throws SQLException {
        UseDB<Object> us = new UseDBImpl();
        Map<String, String > temp = new HashMap<>();
        temp.put("username", "test");
        temp.put("description", "java");
        temp.put("priority", "1");
        System.out.println(us.insert("insert into todo (username, description, priority) values( :username , :description , :priority )",temp));
    }
}