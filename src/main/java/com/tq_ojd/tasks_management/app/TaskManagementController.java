package com.tq_ojd.tasks_management.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tq_ojd.tasks_management.domain.model.TaskObject;
import com.tq_ojd.tasks_management.domain.service.TasksManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskManagementController {
  
  @Autowired
  TasksManagementService tasksManagementService;

  @GetMapping("tasks")
  public List<TaskObject> getAllTasks(){
    return tasksManagementService.getAllTasks();
  }
}
