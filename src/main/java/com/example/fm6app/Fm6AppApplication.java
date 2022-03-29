package com.example.fm6app;

import com.example.fm6app.domain.User;
import com.example.fm6app.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Fm6AppApplication implements CommandLineRunner {
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(Fm6AppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setUsername("admin");
		user.setRole("USER");
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
