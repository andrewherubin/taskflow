/*
 * Taskflow Application - the main entry point for the Taskflow Spring Boot application.
 */

package io.github.andrewherubin.taskflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskflowApplication {

	// Main method to run the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(TaskflowApplication.class, args);
	}

}
