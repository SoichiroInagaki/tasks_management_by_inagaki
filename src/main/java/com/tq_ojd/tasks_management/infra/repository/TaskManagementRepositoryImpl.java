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
    TaskObject domObjTask = new TaskObject();
    domObjTask.setId(task.getId());
    domObjTask.setTitle(task.getTitle());
    domObjTask.setDescription(task.getDescription());
    domObjTask.setCompleted(task.getCompleted());
    domObjTask.setDeadline(task.getDeadline());
    return domObjTask;
  }

  private Task convertToTask(TaskObject domObjTask){
    Task task = new Task();
    task.setId(domObjTask.getId());
    task.setTitle(domObjTask.getTitle());
    task.setDescription(domObjTask.getDescription());
    task.setCompleted(domObjTask.isCompleted());
    task.setDeadline(domObjTask.getDeadline());
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
  public void createTask(TaskObject domObjTask){
    mapper.deleteByPrimaryKey(domObjTask.getId());
  };

  @Override
  public void updateTask(TaskObject domObjTask){
    Task task = convertToTask(domObjTask);
    mapper.updateByPrimaryKey(task);
  };

  @Override
  public void deleteTask(TaskObject domObjTask){
    mapper.deleteByPrimaryKey(domObjTask.getId());
  };
  
}
