package com.taskmanager.TaskManager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.TaskManager.model.Task;
import com.taskmanager.TaskManager.repository.TaskRepository;
import com.taskmanager.TaskManager.service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // 👈 add this
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@Autowired
	private TaskRepository repo;
	
	@PostMapping
	public Task addTask(@RequestBody Task task){
		return service.addTask(task);	
	}
	
	@GetMapping
	public List<Task> getAllTask(){
		return service.getAllTask();
	}
	
//	@GetMapping("/{id}")
//	public Optional<Task> viewTask(@PathVariable Long id) {
//		return repo.findById(id);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
	    Optional<Task> task = repo.findById(id);

	    return task.map(ResponseEntity::ok)
	               .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	
	@PutMapping("/{id}/complete")
	public Task markComplete(@PathVariable Long id) {
		return service.markAsCompleted(id);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable Long id) {
		service.deleteTask(id);
		return "Deleted";
	}
	
	

}
