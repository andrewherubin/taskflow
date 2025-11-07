/*
 * TaskNotFoundException - Custom exception thrown when a task is not found.
 */

package io.github.andrewherubin.taskflow.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Task not found with id:" + id);
    }

    public TaskNotFoundException(String message) {
        super(message);
    }

    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
