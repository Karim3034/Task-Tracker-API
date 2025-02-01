package com.karim.tasks.service;

import com.karim.tasks.domain.entities.TaskEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    List<TaskEntity> retrieveTasks(UUID taskListI);
    TaskEntity createTask(UUID taskListId,TaskEntity task);
    Optional<TaskEntity> getTask(UUID taskListId, UUID TaskId);
    TaskEntity updateTask(UUID taskListId,UUID taskId,TaskEntity task);
    void deleteTask(UUID taskListId,UUID taskId);
}
