package com.karim.tasks.service.Impl;

import com.karim.tasks.domain.entities.TaskListEntity;
import com.karim.tasks.repository.TaskListRepository;
import com.karim.tasks.service.TaskListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {
    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskListEntity> retrieveTasks() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskListEntity addTaskList(TaskListEntity taskListEntity){
        if(null != taskListEntity.getId()){
            throw new IllegalArgumentException("Task list already has an ID!");
        }
        if(null == taskListEntity.getTitle() || taskListEntity.getTitle().isBlank()){
            throw new IllegalArgumentException("Task list must have a title!");
        }
        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskListEntity(
                null,
                taskListEntity.getTitle(),
                taskListEntity.getDescription(),
                null,
                now,
                now
                ));
    }
    @Override
    public void deleteTaskListById(UUID id) {
        taskListRepository.deleteById(id);
    }

    @Override
    public Optional<TaskListEntity> retrieveTaskListById(UUID id) {
        return taskListRepository.findById(id);
    }
    @Transactional
    @Override
    public TaskListEntity updateTaskListById(UUID id,TaskListEntity taskListEntity){
        if(null == taskListEntity.getId()){
            throw new IllegalArgumentException("Task list must have an ID!");
        }
        if(!Objects.equals(id,taskListEntity.getId())){
            throw new IllegalArgumentException("Attempting to change task list id, this is not permitted!");
        }
        TaskListEntity existingTaskList = taskListRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("Task list is not found!"));
        existingTaskList.setTitle(taskListEntity.getTitle());
        existingTaskList.setDescription(taskListEntity.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListRepository.save(existingTaskList);
    }

}
