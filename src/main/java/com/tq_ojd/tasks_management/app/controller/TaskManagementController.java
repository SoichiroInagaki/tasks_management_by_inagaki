package com.tq_ojd.tasks_management.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.tq_ojd.tasks_management.app.model.TaskForm;
import com.tq_ojd.tasks_management.app.model.TaskOutput;
import com.tq_ojd.tasks_management.domain.model.TaskObject;
import com.tq_ojd.tasks_management.domain.service.TasksManagementService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/tasks")
public class TaskManagementController {
  
  @Autowired
  private TasksManagementService tasksManagementService;

  private TaskObject convertToTaskObject(TaskForm taskForm){
    TaskObject taskObject = new TaskObject();
    taskObject.setTitle(taskForm.getTitle());
    taskObject.setDescription(taskForm.getDescription());
    taskObject.setCompleted(taskForm.isCompleted());
    taskObject.setDeadline(taskForm.getDeadline());
    return taskObject;
  }

  private TaskOutput convertToTaskOutput(TaskObject taskObject){
    TaskOutput taskOutput = new TaskOutput();
    taskOutput.setId(taskObject.getId());
    taskOutput.setTitle(taskObject.getTitle());
    taskOutput.setDescription(taskObject.getDescription());
    taskOutput.setCompleted(taskObject.isCompleted());
    taskOutput.setDeadline(taskObject.getDeadline());
    return taskOutput;
  }

  @GetMapping
  public ResponseEntity<List<TaskOutput>> getAllTasks(){
    List<TaskObject> tasksList = tasksManagementService.getAllTasks();
    List<TaskOutput> outputList = new ArrayList<>();
    for(TaskObject taskObject : tasksList){
      outputList.add(convertToTaskOutput(taskObject));
    }
    return ResponseEntity.ok(outputList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TaskOutput> getTask(@PathVariable int id){
    TaskObject taskObject = tasksManagementService.getTask(id);
    TaskOutput taskOutput = convertToTaskOutput(taskObject);
    return ResponseEntity.ok(taskOutput);
  }

  @PostMapping
  public ResponseEntity<TaskOutput> createTask(@RequestBody TaskForm taskForm) {
      TaskObject taskObject = convertToTaskObject(taskForm);
      tasksManagementService.createTask(taskObject);
      TaskOutput taskOutput = convertToTaskOutput(taskObject);
      return ResponseEntity.ok(taskOutput);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TaskOutput> updateTask(@PathVariable int id, @RequestBody TaskForm taskForm){
    TaskObject taskObject = convertToTaskObject(taskForm);
    taskObject.setId(id);
    tasksManagementService.updateTask(taskObject);
    TaskOutput taskOutput = convertToTaskOutput(taskObject);
    return ResponseEntity.ok(taskOutput);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id){
    tasksManagementService.deleteTask(id);
    return ResponseEntity.ok().build();
  }
  
}
