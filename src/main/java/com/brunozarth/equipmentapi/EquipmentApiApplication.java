package com.brunozarth.equipmentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.brunozarth.equipmentapi.repository")
@EntityScan("com.brunozarth.equipmentapi.entity")
@SpringBootApplication
public class EquipmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentApiApplication.class, args);
	}

}
