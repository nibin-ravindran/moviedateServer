package com.project.moviedateServer;

import com.project.moviedateServer.services.WebScrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviedateServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedateServerApplication.class, args);
		new WebScrapper().rottenTomatoScrapper();
	}

}
