package com.timeline.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.timeline.Application;

@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackageClasses = Application.class)
public class SpringBootApplicationConfig {
}
