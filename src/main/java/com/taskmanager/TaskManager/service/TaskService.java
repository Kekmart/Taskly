package com.taskmanager.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.TaskManager.model.Task;
import com.taskmanager.TaskManager.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repo;

	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		return repo.save(task);
	}

	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	public Task markAsCompleted(Long id) {
		// TODO Auto-generated method stub
		Task task=repo.findById(id).orElseThrow();
		task.setCompleted(true);
		return repo.save(task);
	}

}
