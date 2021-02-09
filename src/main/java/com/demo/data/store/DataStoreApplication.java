package com.demo.data.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.demo.data.store.config.TokenConfig;

@SpringBootApplication
@EnableConfigurationProperties(TokenConfig.class)
public class DataStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataStoreApplication.class, args);
	}

}
