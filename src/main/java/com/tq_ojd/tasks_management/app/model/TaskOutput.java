package com.tq_ojd.tasks_management.app.model;

import java.util.Date;

import lombok.Data;

@Data
public class TaskOutput {
  private int id;
  private String title;
  private String description;
  private boolean completed;
  private Date deadline;
}
