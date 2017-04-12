package com.together;

import com.together.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//使用事务
@EnableTransactionManagement
//图片上传相关
@EnableConfigurationProperties(StorageProperties.class)
//使用定时器
@EnableScheduling
//扫描拦截器、监听器等servlet组件
@ServletComponentScan
public class Application {

	// TODO: 2017-04-11 扩展内容描述
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
