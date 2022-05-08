package com.example.fm6app;

import com.example.fm6app.common.BodyView;
import com.example.fm6app.domain.User;
import com.example.fm6app.service.facade.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class Fm6AppApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(Fm6AppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		if (userService.findUserByUsername("admin") != null){
			return;
		}
		User user = new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setUsername("admin");
		user.setPassword("$=LH^Qs6Hj8!I");
		user.setRole("ADMIN");
		userService.addUser(user);
	}
	@JsonView(BodyView.BasicUser.class)
	@PostMapping("/login")
	public ResponseEntity<Map> login(@RequestBody User user) {
		return userService.login(user.getUsername(), user.getPassword());
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
