package com.micronaut_aerospike;

import io.micronaut.openapi.annotation.OpenAPIInclude;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
@OpenAPIDefinition(
        info = @Info(
                title = "Micronaut-aerospike-Swagger",
                version = "0.0",
                description = "Abhijeet Patil",
                license = @License(name = "Apache 2.0", url = "https://abhijeet.bar"),
                contact = @Contact(url = "https://gigantic-server.com", name = "Abhijeet Patil", email = "abhipatil6882@gmail.com")
        )
)
@OpenAPIInclude(
        classes = {io.micronaut.security.endpoints.LoginController.class, io.micronaut.security.endpoints.LogoutController.class},
        tags = @Tag(name = "Authentication")
)

public class Application {
    public static void main(String[] args) {

        Micronaut.run(Application.class, args);
    }
}
