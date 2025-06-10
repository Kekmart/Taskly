package com.taskmanager.TaskManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private boolean completed;
	
//	public void setComplete(boolean complete) {
//		this.completed=complete;
//	}

	public void setCompleted(boolean b) {
		this.completed=b;
		// TODO Auto-generated method stub
		
	}
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean getCompleted() {
		return this.completed;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	//id,title,description,completed

}
