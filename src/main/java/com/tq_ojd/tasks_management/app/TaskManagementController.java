package com.tq_ojd.tasks_management.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
  TasksManagementService tasksManagementService;

  private TaskObject convertToTaskObject(TaskForm taskForm){
    TaskObject taskObject = new TaskObject();
    taskObject.setTitle(taskForm.getTitle());
    taskObject.setDescription(taskForm.getDescription());
    taskObject.setCompleted(taskForm.isCompleted());
    taskObject.setDeadline(taskForm.getDeadline());
    return taskObject;
  }

  @GetMapping
  public ResponseEntity<List<TaskObject>> getAllTasks(){
    List<TaskObject> tasksList = tasksManagementService.getAllTasks();
    return ResponseEntity.ok(tasksList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TaskObject> getTask(@PathVariable int id){
    TaskObject taskObject = tasksManagementService.getTask(id);
    return ResponseEntity.ok(taskObject);
  }

  @PostMapping
  public ResponseEntity<TaskObject> createTask(@RequestBody TaskForm taskForm) {
      TaskObject taskObject = convertToTaskObject(taskForm);
      tasksManagementService.createTask(taskObject);
      return ResponseEntity.ok(taskObject);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TaskObject> updateTask(@PathVariable int id, @RequestBody TaskForm taskForm){
    TaskObject taskObject = convertToTaskObject(taskForm);
    taskObject.setId(id);
    tasksManagementService.updateTask(taskObject);
    return ResponseEntity.ok(taskObject);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable int id){
    tasksManagementService.deleteTask(id);
    return ResponseEntity.noContent().build();
  }
  
}
