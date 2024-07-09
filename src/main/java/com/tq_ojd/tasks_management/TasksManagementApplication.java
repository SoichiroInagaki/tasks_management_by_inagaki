package com.tq_ojd.tasks_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tq_ojd.tasks_management.infra.mapper")
public class TasksManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksManagementApplication.class, args);
	}

}
