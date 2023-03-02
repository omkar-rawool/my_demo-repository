package com.mapping.demo;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class MappingApplication {
	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}
}
