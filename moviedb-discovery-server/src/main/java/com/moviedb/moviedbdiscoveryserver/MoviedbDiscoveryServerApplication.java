package com.moviedb.moviedbdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MoviedbDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedbDiscoveryServerApplication.class, args);
	}

}
