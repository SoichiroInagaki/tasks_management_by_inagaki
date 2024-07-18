package com.tq_ojd.tasks_management.app;

import java.util.Date;

import lombok.Data;

@Data
public class TaskForm {

  private String title;
  private String description;
  private boolean completed;
  private Date deadline;
  
}
