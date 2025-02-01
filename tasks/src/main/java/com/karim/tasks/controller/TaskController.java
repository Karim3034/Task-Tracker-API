package com.karim.tasks.controller;

import com.karim.tasks.domain.dto.TaskDto;
import com.karim.tasks.domain.dto.TaskListDto;
import com.karim.tasks.domain.entities.TaskEntity;
import com.karim.tasks.mappers.TaskMapper;
import com.karim.tasks.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path= "/task-lists/{tasks_list_id}/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> getTasks(@PathVariable("tasks_list_id")UUID taskListId){
        return taskService.retrieveTasks(taskListId).stream().map(
                taskMapper::ToDto).toList();
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@PathVariable("tasks_list_id") UUID taskListId,
                                             @RequestBody TaskDto taskDto)
    {
        TaskEntity taskEntity = taskService.createTask(
                taskListId,
                taskMapper.fromDto(taskDto));
        return new ResponseEntity<>(taskMapper.ToDto(taskEntity),HttpStatus.CREATED);
    }
    @GetMapping("/{task_id}")
    public Optional<TaskDto> getTask(@PathVariable("tasks_list_id") UUID tasksListId,
                                    @PathVariable("task_id") UUID taskId)
    {
        return taskService.getTask(tasksListId,taskId).map(taskMapper::ToDto);
    }

    @PutMapping("/{task_id}")
    public TaskDto updateTask(@PathVariable("tasks_list_id")  UUID tasksListId,
                              @PathVariable("task_id") UUID taskId,
                              @RequestBody TaskDto task)
    {
        TaskEntity taskEntity = taskService.
                updateTask(tasksListId,taskId,
                            taskMapper.fromDto(task));
        return taskMapper.ToDto(taskEntity);

    }
    @DeleteMapping("/{task_id}")
    public void deleteTask(@PathVariable("tasks_list_id")  UUID tasksListId,
                           @PathVariable("task_id") UUID taskId)
    {
        taskService.deleteTask(tasksListId,taskId);
    }
}
