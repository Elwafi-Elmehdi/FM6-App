package com.example.fm6app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Fm6AppApplication {
	public static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		ctx=SpringApplication.run(Fm6AppApplication.class, args);
	}
	public static ConfigurableApplicationContext getCtx() {
		return ctx;
	}
}
