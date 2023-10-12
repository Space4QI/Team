package ru.zulvit.teamentropy.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "zulvit",
                        email = "zulvit.sk@gmail.com"
                ),
                description = "backend for teamentopy",
                title = "betty",
                version = "1.0.0"
        )
)
public class OpenAPIConfig {
}
