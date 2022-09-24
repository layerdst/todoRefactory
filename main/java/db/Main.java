package db;

import dto.TodoDto;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.Date;

public class Main {


	public <T, K, V> Object changeType(ResultSet rs, String type,String name) throws SQLException {
		Object obj=null;
		switch (type){
			case "long" : obj = rs.getInt(name); break;
			case "java.lang.String" : obj =rs.getString(name); break;
			case "int" : obj =rs.getInt(name);break;
			case "java.sql.Date" : obj =rs.getDate(name); break;
		}
		return obj;
	}

	public String changeMethodName(String fieldName){
		return "set"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}


	public Object setTypeClass(String type){
		Object obj=null;
		switch (type){
			case "long" : obj=long.class; break;
			case "java.lang.String" : obj= String.class; break;
			case "int" : obj=int.class; break;
			case "java.sql.Date" : obj = Date.class; break;
		}
		return obj;
	}

	public <CL, T, DTO, M, O> void setMethod(Class<CL> CL, Class<T> T, Class<DTO> dto,  String methodName, Object data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CL.getMethod(methodName, T).invoke(dto,new Object[]{data});
	}

	public <T> List<T> getSelectList(Class<T> dtoClass, ResultSet rs) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		Class dto = dtoClass.getClass();
		List<T> dtos = new ArrayList<T>();

		Field[] fields = dto.getFields();
		Map<String, Object> tempMap = new LinkedHashMap<>();

		for(Field f : fields){
			String fieldName = f.getName();
			Class<?> type = f.getType();
			tempMap.put(fieldName, type);
		}

		while(rs.next()){
			Class temp = dtoClass.getClass();
			for(Map.Entry<String, Object> rsTempMap : tempMap.entrySet()) {
				setMethod(dto,
						(Class<?>)rsTempMap.getValue(),
						temp,
						changeMethodName(rsTempMap.getKey()),
						changeType(rs,rsTempMap.getValue().toString(), rsTempMap.getKey()));
			}
			dtos.add((T) temp);
		}

		return dtos;
	}





	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		DBSelect dbSelect = new DBSelect();


		Class strClass = TodoDto.class;
		Constructor[] cons = strClass.getConstructors();
		System.out.println(strClass.getDeclaredConstructors());

//
//		for(Constructor c : cons){
//			System.out.println(c.getParameterTypes());
//		}

		Field[] fields = strClass.getFields();
		Map<String, Object> tempMap = new LinkedHashMap<>();
		Map<String, String> temp = Arrays.stream(fields).collect(
				Collectors.toMap(v->v.getName(), v->v.getType().getTypeName()));



		Main m = new Main();

		for(Field f : fields){
			String fieldName = f.getName();
			String typeName = f.getType().getTypeName();
			tempMap.put(fieldName, m.setTypeClass(typeName));
		}



		UseDB db = new UseDBImpl<>();





//
		Constructor cs = strClass.getConstructor(new Class[]{long.class, String.class, String.class, int.class, int.class, Date.class});
		Constructor cs2 = strClass.getConstructor();
		TodoDto gDto = (TodoDto) cs2.newInstance();
		TodoDto dto = (TodoDto) cs.newInstance(11L, "22", "22", 3,2, Date.valueOf(LocalDateTime.now().toLocalDate()));


		Arrays.stream(
				strClass.getMethods())
				.iterator()
				.forEachRemaining(
						v-> {
							if(v.getName().contains("Id")){
								gDto.setId(1L);
							}
						}
				);


		Object setId = strClass.getMethod("setId", (Class<?>) tempMap.get("id")).invoke(gDto,new Object[]{51224});
		System.out.println(gDto.getId());

		Main maa = new Main();

		ResultSet rs = null;



//		Arrays.stream(strClass.getMethods())
//				.filter(v->tempMap.entrySet()
//						.stream()
//						.filter(
//								(str)-> {

//									if (tempMethodName.equals(v)) {
//										try {
//											strClass.getMethod(v.getName(), Long.class);
//										} catch (NoSuchMethodException e) {
//											throw new RuntimeException(e);
//										}
//									}
//								}
//						)
//				).collect()


//		System.out.println("===========");
//		System.out.println(gDto.getId());
//
//		System.out.println(dto);
//
//
//
//		UseDB<Object> db = new UseDBImpl<>();
//		db.select("select * from todo");
//
//		System.out.println("------");
//		System.out.println(tempMap);


	}

}
