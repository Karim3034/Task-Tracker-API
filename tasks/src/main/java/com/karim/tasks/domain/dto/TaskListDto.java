package com.karim.tasks.domain.dto;

import com.karim.tasks.domain.entities.TaskEntity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public record TaskListDto (
    UUID id,
    String title,
    String description,
    Integer count,
    Double progress,
    List<TaskDto> tasks
){
}
