package com.timeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.timeline.config.SpringBootApplicationConfig;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootApplicationConfig.class, args);
  }
}
