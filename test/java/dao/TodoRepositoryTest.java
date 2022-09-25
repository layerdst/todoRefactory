package dao;

import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TodoRepositoryTest extends TestCase {



    public static void main(String[] args) throws Exception {
        TodoRepository repo = new TodoRepository();
        Map<String, String> params= new HashMap<>();
        params.put("username", "jjjj");
        params.put("description", "desk");
        params.put("priority", "2");
        System.out.println(repo.insertTodo(params));

        Map<String, String> paramss = new HashMap<>();
        paramss.put("id" , "3");
        System.out.println(repo.updateTodo(paramss));

        System.out.println(repo.getAllTodos());

    }

}