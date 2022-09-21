package dao;

import java.sql.Date;
import java.sql.Timestamp;

public class TodoDto {

	public long id;
	public String username;
	public String description;
	public int stage;
	public int priority;
	public Date regDate;
	
	public TodoDto(long id, String username, String description, int stage, int priority, Date regDate) {
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
		return id + username+description+regDate;
	}
	
	
	
}
