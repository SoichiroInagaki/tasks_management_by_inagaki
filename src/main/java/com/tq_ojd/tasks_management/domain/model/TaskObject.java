package com.tq_ojd.tasks_management.domain.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class TaskObject{

  private int id ;
  private String title;
  private String description;
  private boolean completed;
  private OffsetDateTime deadline;

}
