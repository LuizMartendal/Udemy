package br.com.erudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestWithSpringBootAndJavaErudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringBootAndJavaErudioApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

	@RequestMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}

}
