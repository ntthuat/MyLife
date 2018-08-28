package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/06/26 11:09:21 $
 * $Log: SpringBootViewApplication.java,v $
 */
@SpringBootApplication
public class SpringBootViewApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootViewApplication.class, args);
    System.out.println("Check here: http://localhost:12369/");
    System.out.println("Database here: http://localhost:12369/h2-console");
  }
}
