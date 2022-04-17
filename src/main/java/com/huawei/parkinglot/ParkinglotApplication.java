package com.huawei.parkinglot;

import com.huawei.parkinglot.entity.security.User;
import com.huawei.parkinglot.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkinglotApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ParkinglotApplication.class, args);
	}


}
