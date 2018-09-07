package com.ancaiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AncaiyunAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AncaiyunAdminServerApplication.class, args);
	}
}
