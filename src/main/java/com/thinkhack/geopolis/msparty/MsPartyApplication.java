package com.thinkhack.geopolis.msparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MsPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPartyApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "GeoPolis API - Party Microservices - v0.1";
	}

}
