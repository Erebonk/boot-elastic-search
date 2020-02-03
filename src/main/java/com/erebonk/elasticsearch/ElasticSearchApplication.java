package com.erebonk.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ElasticSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchApplication.class, args);
	}

}
