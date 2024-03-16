package com.springlearning.springrestconsume;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
public class SpringRestConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestConsumeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner runner(RestTemplate restTemplate){
		return args -> {
			System.out.println("run when spring application start");
			Message message = restTemplate.getForObject(new URI("http://localhost:8080/getMessage?index=2"), Message.class);
			System.out.println(message.toString());
		};
	}

}
