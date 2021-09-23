package edu.coursework.sportschool.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    //@Bean
    public OpenAPI sportSchoolOpenApi(){

        return new OpenAPI().
                info(
                        new Info()
                                .title("Практика")
                                .version("1.0")
                                .contact(new Contact()
                                        .name("Anton")
                                        .url("my-site.cv.ua"))

                );
    }
}
