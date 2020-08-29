package com.dev.quack.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private String name;
	private String fatherName;
	private String stream;
	    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", stream=" + stream + "]";
	}
	
	
	

}
