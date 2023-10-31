package io.github.Rique25.Vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
