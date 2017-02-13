package com.app.initializer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan( basePackages = {"com.app" } )
@ComponentScan( {"com.app" } )
public class SpringBootRunner {
	
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-datasource.xml");	
		SpringApplication.run(SpringBootRunner.class, args);
		
//		((ConfigurableApplicationContext) applicationContext).close();
	}

}
