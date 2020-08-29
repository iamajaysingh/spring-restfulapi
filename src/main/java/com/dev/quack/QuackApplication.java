package com.dev.quack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()

/*@EnableAutoConfiguration*/
public class QuackApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context  =SpringApplication.run(QuackApplication.class, args);
	Computer c1	= context.getBean(Computer.class);
		 c1.show("first object");
			Computer c2	= context.getBean(Computer.class);
			c1.show("second object");
			System.out.println(c1+"@@@@"+ c2);
		System.out.println("hello Quack project");
	}

}
