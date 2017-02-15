package com.app.initializer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@EntityScan( basePackages = {"com.app" } )
@ComponentScan( {"com.app" } )
@ImportResource( {"classpath:springservlet.xml"} )
public class SpringBootRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);
	}

}
