package com.karim.tasks.mappers.impl;

import com.karim.tasks.domain.dto.TaskDto;
import com.karim.tasks.domain.entities.TaskEntity;
import com.karim.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskDto ToDto(TaskEntity taskEntity) {
        return new TaskDto(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getDueDate(),
                taskEntity.getPriority(),
                taskEntity.getStatus()
        );
    }
    @Override
    public TaskEntity fromDto(TaskDto taskDto) {
        return new TaskEntity(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.priority(),
                taskDto.status(),
                null,
                null,
                null
        );
    }
}
