package com.dev.quack;

import java.util.List;
import java.util.Locale;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication()

@EnableAutoConfiguration
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
	// Instead of Using SessionLocalResolver we can use AcceptHeaderLocaleResolver
	@Bean
	public AcceptHeaderLocaleResolver localResolver() {
		AcceptHeaderLocaleResolver acceptLocaleResolver = new AcceptHeaderLocaleResolver();
		acceptLocaleResolver.setDefaultLocale(Locale.US);
		
		List<Locale> localeList=acceptLocaleResolver.getSupportedLocales();
		for(Locale locale : localeList) {
			System.out.println(locale.getCountry()+"====================================");
		}
		
		return acceptLocaleResolver;
	}
	// we can define this property in application properties file spring.messages.basename=messages
/*	@Bean(name="messageSource")
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageReource = new ResourceBundleMessageSource();
		messageReource.setBasename("messages");
		
		return messageReource;
		
		
	}*/

}
