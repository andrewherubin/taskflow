/*
 * Task - entity representing a task in the TaskFlow application.
 */

package io.github.andrewherubin.taskflow.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Schema(description = "Unique identifier of the Task.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(description = "Name of the Task.", example = "Finish report")
    @NotBlank(message = "Task name is required")
    @Size(max = 100, message = "Task name must be at most 100 characters")
    private String name;

    @Schema(description = "Detailed description of the Task.", example = "Complete the financial report for Q2.")
    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;

    @Schema(description = "Current status of the Task.", example = "PENDING")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Task status is required")
    private Status status = Status.PENDING;

    @Schema(description = "Due date of the Task.", example = "2024-12-31")
    private LocalDate dueDate;

    // Enumeration for Task Status
    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}
