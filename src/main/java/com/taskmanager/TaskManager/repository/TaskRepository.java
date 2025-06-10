package com.taskmanager.TaskManager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmanager.TaskManager.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
