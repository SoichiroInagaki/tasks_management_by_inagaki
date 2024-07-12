package com.tq_ojd.tasks_management.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TaskObject implements Serializable{

  private static final long serialVersionUID = 1L;

  private int id ;
  private String title;
  private String description;
  private boolean completed;
  private Date deadline;

}
