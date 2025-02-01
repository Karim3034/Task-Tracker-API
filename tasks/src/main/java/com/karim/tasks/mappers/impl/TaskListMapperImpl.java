package com.karim.tasks.mappers.impl;

import com.karim.tasks.domain.dto.TaskListDto;
import com.karim.tasks.domain.entities.TaskEntity;
import com.karim.tasks.domain.entities.TaskListEntity;
import com.karim.tasks.domain.entities.TaskStatus;
import com.karim.tasks.mappers.TaskListMapper;
import com.karim.tasks.mappers.TaskMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.karim.tasks.domain.entities.TaskStatus.CLOSED;

@Component
public class TaskListMapperImpl implements TaskListMapper {
    TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskListEntity fromDto(TaskListDto taskListDto) {
        return TaskListEntity.builder()
                .id(taskListDto.id())
                .title(taskListDto.title())
                .description(taskListDto.description())
                .tasks(Optional.ofNullable(taskListDto.tasks()).map(
                        tasks -> tasks.stream()
                                .map(taskMapper::fromDto).toList()).orElse(null))
                .build();
//                taskListDto.id(),
//                taskListDto.title(),
//                taskListDto.description(),
//                Optional.ofNullable(
//                        taskListDto.tasks()).map(tasks-> tasks.stream()
//                        .map(taskMapper::fromDto)
//                        .toList()).orElse(null),
//                null,
//                null
//
//        );
    }

    @Override
    public TaskListDto toDto(TaskListEntity taskListEntity) {
        return new TaskListDto(taskListEntity.getId(),
                taskListEntity.getTitle(),
                taskListEntity.getDescription(),
                Optional.ofNullable(
                        taskListEntity.getTasks()).map(List::size).orElse(0),
                calculateTasksProgress(taskListEntity.getTasks()),
                Optional.ofNullable(
                        taskListEntity.getTasks()).map(
                                tasks -> tasks.stream().map(taskMapper::ToDto).toList()).orElse(null)
                );
    }
    private Double calculateTasksProgress(List<TaskEntity> tasks){
        if(null == tasks) {
            return null;
        }
       long progress = tasks.stream().filter(
               task -> (TaskStatus.CLOSED == task.getStatus())
       ).count();
        return (double)progress/tasks.size();
    }
}
