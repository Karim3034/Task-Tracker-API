package com.karim.tasks.domain.dto;

import com.karim.tasks.domain.entities.TaskListEntity;
import com.karim.tasks.domain.entities.TaskPriority;
import com.karim.tasks.domain.entities.TaskStatus;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public record TaskDto (
    UUID id,
    String title,
    String description,
    Date dueDate,
    TaskPriority priority,
    TaskStatus status
){
}
