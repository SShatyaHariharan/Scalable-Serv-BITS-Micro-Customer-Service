package com.bits.customerservice.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Configuration
	public class RestTemplateConfig {
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	}

}
