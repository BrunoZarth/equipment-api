package com.brunozarth.equipmentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EquipmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentApiApplication.class, args);
	}

}
