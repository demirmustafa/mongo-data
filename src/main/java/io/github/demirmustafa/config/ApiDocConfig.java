package io.github.demirmustafa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by mustafa on 4/29/17.
 */
@Configuration
@EnableSwagger2
public class ApiDocConfig {

    @Bean
    public Docket apiDoc(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(getApiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo getApiInfo(){
        Contact contactMe = new Contact("Mustafa Demir","https://demirmustafa.github.io","g.demirmustafa@gmail.com");
        return new ApiInfoBuilder()
                .contact(contactMe)
                .description("Some Description")
                .license("Some public license")
                .title("Api Doc")
                .build();
    }
}
