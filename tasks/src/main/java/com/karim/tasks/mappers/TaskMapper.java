package com.karim.tasks.mappers;

import com.karim.tasks.domain.dto.TaskDto;
import com.karim.tasks.domain.entities.TaskEntity;

public interface TaskMapper {
    TaskDto ToDto(TaskEntity taskEntity);
    TaskEntity fromDto(TaskDto taskDto);
}
