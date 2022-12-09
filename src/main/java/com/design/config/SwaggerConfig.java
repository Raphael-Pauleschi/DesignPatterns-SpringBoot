package com.design.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.design.controller";
	private static final String API_TITLE = "Design patterns";
	private static final String API_DESCRIPTION = "Uso de design patterns em uma api";
	private static final String CONTACT_NAME = "Raphael Ferraiolo";
	private static final String CONTACT_GITHUB = "https://github.com/Raphael-Pauleschi";
	private static final String CONTACT_EMAIL = "raphael.f.pauleschi@outlook.com";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build().apiInfo(buildApiInfo()).
				securitySchemes(Arrays.asList(apiKey()));
		
		 
	}

	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder().title(API_TITLE)
				.description(API_DESCRIPTION)
				.version("1.0.0")
				.contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}
}
