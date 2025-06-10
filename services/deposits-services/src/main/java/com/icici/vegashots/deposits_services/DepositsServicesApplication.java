package com.icici.vegashots.deposits_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepositsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepositsServicesApplication.class, args);
	}

}