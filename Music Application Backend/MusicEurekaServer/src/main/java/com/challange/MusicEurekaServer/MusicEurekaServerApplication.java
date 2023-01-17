package com.challange.MusicEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MusicEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicEurekaServerApplication.class, args);
	}

}
