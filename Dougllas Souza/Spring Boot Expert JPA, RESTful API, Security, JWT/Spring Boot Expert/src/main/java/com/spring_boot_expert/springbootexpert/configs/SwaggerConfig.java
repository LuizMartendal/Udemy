package com.spring_boot_expert.springbootexpert.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vendas API")
                        .version("1.0")
                        .contact(contact())
                        .description("Api de vendas do curso Spring Expert")
                );
    }

    private Contact contact() {
        Contact contact = new Contact();
        contact.setName("Luiz Henrique Martendal");
        contact.setUrl("http://github.com/Rique25");
        contact.setEmail("luiz.martendal52@gmail.com");
        return contact;
    }
}
