/*
 * TaskService - service class for managing tasks.
 */

package io.github.andrewherubin.taskflow.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import io.github.andrewherubin.taskflow.exception.TaskNotFoundException;
import io.github.andrewherubin.taskflow.model.Task;
import io.github.andrewherubin.taskflow.repository.TaskRepository;

@Service
public class TaskService {
    
    // Repository for task data
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Retrieve all tasks from the repository/database
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    // Retrieve a task by its ID
    public Task getTaskById(@NonNull Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    // Create a new task in the repository/database
    public Task createTask(@NonNull Task task) {
        return taskRepository.save(task);
    }

    // Update an existing task by its ID
    public Task updateTask(@NonNull Long id, @NonNull Task updatedTask) {
        Task existing = taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        existing.setName(updatedTask.getName());
        existing.setDescription(updatedTask.getDescription());
        existing.setDueDate(updatedTask.getDueDate());
        existing.setStatus(updatedTask.getStatus());

        return taskRepository.save(existing);
    }

    // Delete a task by its ID
    public void deleteTask(@NonNull Long id) {
        taskRepository.deleteById(id);
    }
}