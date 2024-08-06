package com.project2.VaccinationCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;*/

@EnableFeignClients
@SpringBootApplication
public class VaccinationCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCenterApplication.class, args);
	}
	/*
	 * @Bean
	 * 
	 * @LoadBalanced RestTemplate getRestTemplate() { return new RestTemplate(); }
	 */

}
