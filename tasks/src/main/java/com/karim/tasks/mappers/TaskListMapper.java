package com.karim.tasks.mappers;

import com.karim.tasks.domain.dto.TaskListDto;
import com.karim.tasks.domain.entities.TaskListEntity;
import org.springframework.context.annotation.Bean;

public interface TaskListMapper {
    TaskListEntity fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskListEntity taskListEntity);
}
