package db;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import dao.TodoDao;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBSelect dbSelect = new DBSelect();
//		List<TodoDao> list= dbSelect.getTodos();

		Class strClass = TodoDao.class;
		Constructor[] cons = strClass.getConstructors();
		for(Constructor c : cons){
			System.out.println(c);
		}

		System.out.println();

		Field[] fields = strClass.getFields();
		for(Field f : fields){
			System.out.println(f);
		}

//		DB db = new DB();
//		List<TodoDao> todos = db.getConnections().getPrepareStatement("select * from todo").getResultQuery().set().getTodos();
//		for(TodoDao t : todos ){
//			System.out.println(t.toString());
//		}


//		for(TodoDao dao : list) {
//			System.out.println(dao.toString());
//		}
	}

}
