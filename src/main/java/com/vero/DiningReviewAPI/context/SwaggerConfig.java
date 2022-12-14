package com.vero.DiningReviewAPI.context;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vero.DiningReviewAPI"))
                .paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Dining Review API",
            "API REST of Dining Review.",
            "v1",
            "Terms of service",
            new Contact ("Vero","www.example.com","vero.gconesa@gmail.com"),
            "License of API", "API license URL", Collections.emptyList());
         
    }

    
    
}
