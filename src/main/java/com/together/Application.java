package com.together;

import com.together.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling
public class Application {

	// TODO: 2017-04-11 扩展内容描述
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
