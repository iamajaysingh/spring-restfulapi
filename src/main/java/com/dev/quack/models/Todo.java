package com.dev.quack.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "todo")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min =2, message="Name should contain at least more than one character.")
	@NotNull(message="username can not be  null, please fill details carefully")
	private String username;
	
	
	private String description;
	
	
	private Date createdDate;
	private boolean isDone;
	private boolean isImportant;

	public Todo(int id, String username, String description, Date createdDate, boolean isDone, boolean isImportant) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.createdDate = createdDate;
		this.isDone = isDone;
		this.isImportant = isImportant;
	}
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public boolean isImportant() {
		return isImportant;
	}

	public void setImportant(boolean isImportant) {
		this.isImportant = isImportant;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", createdDate="
				+ createdDate + ", isDone=" + isDone + ", isImportant=" + isImportant + "]";
	}

}
