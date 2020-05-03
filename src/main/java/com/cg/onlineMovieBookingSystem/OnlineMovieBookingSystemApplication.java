package com.cg.onlineMovieBookingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

//import com.cg.onlineMovieBookingSystem.controller.TheatreController;

@SpringBootApplication
//@ComponentScan(basePackageClasses = TheatreController.class)
public class OnlineMovieBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieBookingSystemApplication.class, args);
	}

}
