package com.tq_ojd.tasks_management.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tq_ojd.tasks_management.domain.model.TaskObject;
import com.tq_ojd.tasks_management.domain.repository.TaskManagementRepository;

@Service
@Transactional
public class TasksManagementService {

  @Autowired
  private TaskManagementRepository repository;

  public List<TaskObject> getAllTasks(){
    return repository.getAllTasks();
  }

  public TaskObject getTask(int id){
    return repository.getTask(id);  
  }

  public void createTask(TaskObject task){
    repository.createTask(task);
  }
  
  public void updateTask(TaskObject taskObject){
    repository.updateTask(taskObject);
  }

  public void deleteTask(int id){
    getTask(id);
    repository.deleteTask(id);
  }
} 
