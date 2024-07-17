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

  // public TaskObject getTask(Integer id){
  //   return repository.getTask(id);  
  // }

  public void createTask(TaskObject task){
    repository.createTask(task);
  }
  
  // public void updateTask(Integer id, TaskObject requestBody){
  //   TaskObject task = getTask(id);
  //   task.setTitle(requestBody.getTitle() == null ? task.getTitle() : requestBody.getTitle());
  //   task.setDescription(requestBody.getDescription() == null ? task.getDescription() : requestBody.getDescription());
  //   task.setCompleted(requestBody.getCompleted() == null ? task.getCompleted() : requestBody.getCompleted());
  //   task.setDeadline(requestBody.getDeadline() == null ? task.getDeadline() : requestBody.getDeadline());
  //   return TaskRepository.save(task);
  // }

  // public void deleteTask(Integer id){
  //   getTask(id);
  //   TaskRepository.deleteById(id);
  // }
} 
