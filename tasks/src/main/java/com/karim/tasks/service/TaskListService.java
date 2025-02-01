package com.karim.tasks.service;

import com.karim.tasks.domain.entities.TaskListEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskListEntity> retrieveTasks();
    TaskListEntity addTaskList(TaskListEntity taskListEntity);
    void deleteTaskListById(UUID id);
    Optional<TaskListEntity> retrieveTaskListById(UUID id);
    TaskListEntity updateTaskListById(UUID id,TaskListEntity taskListEntity);
}