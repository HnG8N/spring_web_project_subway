package com.springlec.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //servlet auto register
@SpringBootApplication
public class SubwayProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubwayProjectApplication.class, args);
	}

}
