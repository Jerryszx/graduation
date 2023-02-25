package org.szx.graduation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.szx.graduation.control","org.szx.graduation.model"
,"org.szx.graduation.service"})
public class ProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		String  springBootVersion= SpringBootVersion.getVersion();
		System.out.println(springBootVersion);
	}

}
