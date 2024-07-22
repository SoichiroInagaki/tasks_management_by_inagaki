package com.tq_ojd.tasks_management.infra.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tq_ojd.tasks_management.domain.model.TaskObject;
import com.tq_ojd.tasks_management.domain.repository.TaskManagementRepository;
import com.tq_ojd.tasks_management.infra.entity.Task;
import com.tq_ojd.tasks_management.infra.mapper.TaskMapper;

@Repository
public class TaskManagementRepositoryImpl implements TaskManagementRepository{

  @Autowired
  private TaskMapper mapper;

  private TaskObject convertToTaskObject(Task task){
    TaskObject taskObject = new TaskObject();
    taskObject.setId(task.getId());
    taskObject.setTitle(task.getTitle());
    taskObject.setDescription(task.getDescription());
    taskObject.setCompleted(task.getCompleted());
    taskObject.setDeadline(task.getDeadline());
    return taskObject;
  }

  private Task convertToTask(TaskObject taskObject){
    Task task = new Task();
    task.setId(taskObject.getId());
    task.setTitle(taskObject.getTitle());
    task.setDescription(taskObject.getDescription());
    task.setCompleted(taskObject.isCompleted());
    task.setDeadline(taskObject.getDeadline());
    return task;
  }

  @Override
  public TaskObject getTask(int id){
    Task task = mapper.selectByPrimaryKey(id);
    return convertToTaskObject(task);
  };

  @Override
  public List<TaskObject> getAllTasks(){
    List<Task> taskList = mapper.selectByExample(null);
    List<TaskObject> taskObjectList = new ArrayList<TaskObject>();
    for(Task task : taskList){
      TaskObject taskObject = convertToTaskObject(task);
      taskObjectList.add(taskObject);
    }
    return taskObjectList;
  }; 

  @Override
  public void createTask(TaskObject taskObject){
    Task task = convertToTask(taskObject);
    mapper.insert(task);
  };

  @Override
  public void updateTask(TaskObject taskObject){
    Task task = convertToTask(taskObject);
    mapper.updateByPrimaryKey(task);
  };

  @Override
  public void deleteTask(int id){
    mapper.deleteByPrimaryKey(id);
  };
  
}
