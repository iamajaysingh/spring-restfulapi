package com.dev.quack;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value ="prototype")
public class Computer {
	
	public void show(String response) {
		
		System.out.println(response);
	}

}
