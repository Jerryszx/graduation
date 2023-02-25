package org.szx.graduation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.szx.graduation.control","org.szx.graduation.model","org.szx.graduation.session"
,"org.szx.graduation.dao","org.szx.graduation.dataobject"})
public class ProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
