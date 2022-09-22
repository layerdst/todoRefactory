package db;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class MakeSqlTest extends TestCase {

    public static String sql = "insert table asdfa (a) values( :id , :name )";
    public static NoInputQuerySelect ma = new NoInputQuerySelect(sql);



    public static void main(String[] args) {
        Map<String, Object> test = new HashMap<>();
        test.put("id", 1);
        test.put("name","이름");
        System.out.println(ma.setSql(test, sql));

        String testData = "ddd sss gdsgd sdf";
        testData.replace("ddd","aa");

        System.out.println(testData);
    }
}