package com.nejlasahin.invoicemanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080/");
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("nejlasahin.dev@gmail.com");
        contact.setName("Nejla Sahin");
        contact.setUrl("https://github.com/nejlasahin");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Invoice Management API")
                .version("1.0")
                .contact(contact)
                .description("This API endpoints to invoice management.").termsOfService("https://github.com/nejlasahin")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
