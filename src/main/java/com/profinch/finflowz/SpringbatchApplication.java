package com.profinch.finflowz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.profinch.finflowz"})
@EnableJpaRepositories({"com.profinch.finflowz"})
@EntityScan({"com.profinch.finflowz"})
public class SpringbatchApplication {

	static Logger log = LoggerFactory.getLogger(SpringbatchApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(SpringbatchApplication.class, args);
	}

}
