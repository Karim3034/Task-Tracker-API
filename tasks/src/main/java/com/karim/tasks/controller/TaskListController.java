package com.karim.tasks.controller;


import com.karim.tasks.domain.entities.TaskListEntity;
import com.karim.tasks.mappers.TaskListMapper;
import com.karim.tasks.service.TaskListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.karim.tasks.domain.dto.TaskListDto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {
    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> getTaskLists(){
        return taskListService.retrieveTasks()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping
    public ResponseEntity<TaskListDto> createTaskList(@RequestBody TaskListDto taskListDto){
        return new ResponseEntity<>(taskListMapper.toDto(taskListService.addTaskList(taskListMapper.fromDto(taskListDto))), HttpStatus.CREATED);
    }
    @GetMapping(path = "/{task_list_id}")
    public ResponseEntity<Optional<TaskListDto>> getTaskListById(@PathVariable("task_list_id")UUID id){
        return new ResponseEntity<>(taskListService.retrieveTaskListById(id).map(taskListMapper::toDto),HttpStatus.OK);
    }
    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(@PathVariable("task_list_id")UUID id,
                                      @RequestBody TaskListDto taskListDto)
    {
        TaskListEntity updatedTaskList = taskListService.updateTaskListById(
                id,
                taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(updatedTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id")UUID id){
        taskListService.deleteTaskListById(id);
    }

}
