package com.tq_ojd.tasks_management.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.tq_ojd.tasks_management.app.openapi.api.TasksApi;
import com.tq_ojd.tasks_management.app.openapi.model.RequestTask;
import com.tq_ojd.tasks_management.app.openapi.model.ResponseTask;
import com.tq_ojd.tasks_management.domain.model.TaskObject;
import com.tq_ojd.tasks_management.domain.service.TasksManagementService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tasks")
public class TaskManagementController implements TasksApi{
  
  @Autowired
  private TasksManagementService tasksManagementService;

  private TaskObject convertToTaskObject(RequestTask requestTask){
    TaskObject taskObject = new TaskObject();
    taskObject.setTitle(requestTask.getTitle());
    taskObject.setDescription(requestTask.getDescription());
    taskObject.setCompleted(requestTask.getCompleted());
    taskObject.setDeadline(requestTask.getDeadline());
    return taskObject;
  }

  private ResponseTask convertToResponseTask(TaskObject taskObject){
    ResponseTask responseTask = new ResponseTask();
    responseTask.setId(taskObject.getId());
    responseTask.setTitle(taskObject.getTitle());
    responseTask.setDescription(taskObject.getDescription());
    responseTask.setCompleted(taskObject.isCompleted());
    responseTask.setDeadline(taskObject.getDeadline());
    return responseTask;
  }

  @Override
  @GetMapping
  public ResponseEntity<List<ResponseTask>> getAllTasks(){
    List<TaskObject> tasksList = tasksManagementService.getAllTasks();
    List<ResponseTask> responseList = new ArrayList<>();
    for(TaskObject taskObject : tasksList){
      responseList.add(convertToResponseTask(taskObject));
    }
    return ResponseEntity.ok(responseList);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<ResponseTask> getTask(
    @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) 
    @PathVariable("id") Integer id
) {
    TaskObject taskObject = tasksManagementService.getTask(id);
    ResponseTask responseTask = convertToResponseTask(taskObject);
    return ResponseEntity.ok(responseTask);
  }

  @Override
  @PostMapping
  public ResponseEntity<ResponseTask> createTask(
    @Parameter(name = "RequestTask", description = "") 
    @Valid @RequestBody(required = false) RequestTask requestTask
  ) {
      TaskObject taskObject = convertToTaskObject(requestTask);
      tasksManagementService.createTask(taskObject);
      ResponseTask responseTask = convertToResponseTask(taskObject);
      return ResponseEntity.ok(responseTask);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<ResponseTask> updateTask(
    @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) 
    @PathVariable("id") Integer id, @Parameter(name = "RequestTask", description = "") 
    @Valid @RequestBody(required = false) RequestTask requestTask
) {
    TaskObject taskObject = convertToTaskObject(requestTask);
    taskObject.setId(id);
    tasksManagementService.updateTask(taskObject);
    ResponseTask responseTask = convertToResponseTask(taskObject);
    return ResponseEntity.ok(responseTask);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(
    @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) 
    @PathVariable("id") Integer id
) {
    tasksManagementService.deleteTask(id);
    return ResponseEntity.ok().build();
  }
  
}
