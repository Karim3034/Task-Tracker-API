package com.karim.tasks.service.Impl;

import com.karim.tasks.domain.entities.TaskEntity;
import com.karim.tasks.domain.entities.TaskListEntity;
import com.karim.tasks.domain.entities.TaskPriority;
import com.karim.tasks.domain.entities.TaskStatus;
import com.karim.tasks.mappers.TaskMapper;
import com.karim.tasks.repository.TaskListRepository;
import com.karim.tasks.repository.TaskRepository;
import com.karim.tasks.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    public List<TaskEntity> retrieveTasks(UUID taskListID) {
        return taskRepository.findByTaskListId(taskListID);
    }

    public TaskEntity createTask(UUID taskListId,TaskEntity task){
        if(null != task.getId()){
            throw new IllegalArgumentException("Task is already has an ID!");
        }
        if(null == task.getTitle() || task.getTitle().isBlank()){
            throw new IllegalArgumentException("Task must have a title!");
        }
        TaskStatus taskStatus = Optional.ofNullable(task.getStatus()).orElse(TaskStatus.OPEN);
        TaskPriority taskPriority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM);
        TaskListEntity taskList = taskListRepository.findById(taskListId).orElseThrow(
                ()-> new IllegalArgumentException("Invalid task list ID!")
        );

        LocalDateTime now = LocalDateTime.now();
        TaskEntity taskEntity = new TaskEntity(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskPriority,
                taskStatus,
                taskList,
                now,
                now
        );
        return taskRepository.save(taskEntity);
    }
    public Optional<TaskEntity> getTask(UUID taskListId, UUID taskId){
        return taskRepository.findByTaskListIdAndId(taskListId,taskId);
    }
    @Transactional
    @Override
    public TaskEntity updateTask(UUID taskListId, UUID taskId, TaskEntity task) {
        if(null == taskListId){
            throw new IllegalArgumentException("Invalid task list ID!");
        }
        if(null == taskId){
            throw new IllegalArgumentException("Invalid task ID!");
        }
        if(!Objects.equals(taskId,task.getId())){
            throw new IllegalArgumentException("Attempting to change task ID, this is not permitted");
        }


        TaskEntity taskEntity = taskRepository.
                findByTaskListIdAndId(taskListId,taskId).
                orElseThrow(()->new IllegalArgumentException("Task is not found!"));

        taskEntity.setTitle(task.getTitle());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setDueDate(task.getDueDate());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setUpdated(LocalDateTime.now());

        return taskRepository.save(taskEntity);
    }

    @Override
    @Transactional
    public void deleteTask(UUID taskListId, UUID taskId) {
        taskRepository.deleteByTaskListIdAndId(taskListId,taskId);
    }

}
