package dto;

import java.sql.Date;
import java.sql.Timestamp;

public class TodoDto {

	public long id;
	public String username;
	public String description;
	public int stage;
	public int priority;
	public Date regDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public TodoDto(){

	}
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
