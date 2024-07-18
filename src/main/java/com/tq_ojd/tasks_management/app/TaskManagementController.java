package com.tq_ojd.tasks_management.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tq_ojd.tasks_management.domain.model.TaskObject;
import com.tq_ojd.tasks_management.domain.service.TasksManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("tasks")
public class TaskManagementController {
  
  @Autowired
  TasksManagementService tasksManagementService;

  private TaskObject convertToTaskObject(TaskForm taskForm){
    TaskObject taskObject = new TaskObject();
    taskObject.setTitle(taskForm.getTitle());
    taskObject.setDescription(taskObject.getDescription());
    taskObject.setCompleted(taskObject.isCompleted());
    taskObject.setDeadline(taskObject.getDeadline());
    return taskObject;
  }

  @GetMapping
  public List<TaskObject> getAllTasks(){
    return tasksManagementService.getAllTasks();
  }

  @PostMapping
  public List<TaskObject> createTask(@RequestBody TaskForm taskForm) {
      TaskObject taskObject = convertToTaskObject(taskForm);
      tasksManagementService.createTask(taskObject);
      return tasksManagementService.getAllTasks();
  }
  
}
