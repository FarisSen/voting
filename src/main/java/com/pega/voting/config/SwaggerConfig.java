package com.pega.voting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.pega.voting.controller"))
        .paths(PathSelectors.any()).build().apiInfo(this.apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Eurovision")
        .description("​Java REST API ​ for Eurovision Song Contest Voting System")
        .contact(new Contact("Faris Sen", "http://github.com/farissen",
            "farissen@hotmail.com"))
        .build();
  }
}
