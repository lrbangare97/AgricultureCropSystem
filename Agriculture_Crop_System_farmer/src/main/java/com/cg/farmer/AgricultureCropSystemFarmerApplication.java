package com.cg.farmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class AgricultureCropSystemFarmerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgricultureCropSystemFarmerApplication.class, args);
	}

}
