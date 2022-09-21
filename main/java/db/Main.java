package db;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;

import dao.TodoDto;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBSelect dbSelect = new DBSelect();
//		List<TodoDao> list= dbSelect.getTodos();

		Class strClass = TodoDto.class;
		Constructor[] cons = strClass.getConstructors();

		System.out.println(TodoDto.class.getName());


		for(Constructor c : cons){
			System.out.println(c);
		}

		System.out.println();

		Field[] fields = strClass.getFields();
		for(Field f : fields){
			String fieldName = f.getName();
			String typeName = f.getType().getTypeName();

			System.out.println(typeName + " " + fieldName);
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
