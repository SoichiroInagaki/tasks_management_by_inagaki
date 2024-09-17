package com.tq_ojd.tasks_management.app.model;

import java.time.LocalDateTime; 

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TaskForm {

  private String title;
  private String description;
  private boolean completed;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZZZ")
  private LocalDateTime deadline;
  
}
