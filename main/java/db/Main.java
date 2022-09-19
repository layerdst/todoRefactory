package db;

import java.util.List;

import dao.TodoDao;

public class Main {
	public static void main(String[] args) {
		DBConnection dbConnection = new DBConnection();
		List<TodoDao> list= dbConnection.getTodos();
		
		for(TodoDao dao : list) {
			System.out.println(dao.toString());
		}
	}

}
