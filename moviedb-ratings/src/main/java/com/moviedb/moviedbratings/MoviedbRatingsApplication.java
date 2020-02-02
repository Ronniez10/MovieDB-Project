package com.moviedb.moviedbratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MoviedbRatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedbRatingsApplication.class, args);
	}

}
