package com.una.carassiststorebackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.una.carassiststorebackend.repositories")
@OpenAPIDefinition(info = @Info(title = "Car Assist Store", version = "1.0", description = "Car Assist Store API",
        license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"),
        contact = @Contact(name = "Koala's Software Support", email = "henrique.wallace@hotmail.com"),
        termsOfService = "http://koalassoftware.com/use_terms_api"
))
public class CarAssistStoreBackendApplication {

    private static final Logger log = LoggerFactory.getLogger(CarAssistStoreBackendApplication.class);

    public static void main(String[] args) {
        log.info("Initializing...");

        System.setProperty("server.servlet.context-path", "/car-store-api");
        System.setProperty("server.port", "8080");
        new SpringApplicationBuilder(CarAssistStoreBackendApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
