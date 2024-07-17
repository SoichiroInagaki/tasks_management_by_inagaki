package com.tq_ojd.tasks_management.domain.repository;

import java.util.List;

import com.tq_ojd.tasks_management.domain.model.TaskObject;

public interface TaskManagementRepository{

  TaskObject getTask(int id);
  List<TaskObject> getAllTasks();
  void createTask(TaskObject task);
  void updateTask(TaskObject task);
  void deleteTask(TaskObject task);

}
