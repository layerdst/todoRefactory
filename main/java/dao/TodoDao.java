package dao;

import java.sql.Timestamp;

public class TodoDao {

	long id;
	String username;
	String description;
	int stage;
	int priority;
	Timestamp regDate;
	
	public TodoDao(long id, String username, String description, int stage, int priority, Timestamp regDate) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.stage = stage;
		this.priority = priority;
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + username+description;
	}
	
	
	
}
