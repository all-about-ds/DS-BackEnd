package com.ds.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;


@ConfigurationPropertiesScan
@SpringBootApplication
@EnableWebSocketMessageBroker
@EnableScheduling
public class DsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsApplication.class, args);
	}

}
