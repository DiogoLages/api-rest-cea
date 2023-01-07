package br.com.cea.diogo.controller.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.cea.diogo.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("API Projeto",
				"Construir um serviço REST em Java com os seguintes endpoints:\r\n\n"
				+ "1) Endpoint para cadastrar um novo produto.\r\n\n"
				+ "2) Endpoint que receba uma lista de códigos de departamentos na requisição e retorne, "
				+ "para cada código requerido, a quantidade de produtos pertencentes a ele por classificação (A,B,C, ou #).", "Versão 1.0",
				"https://www.linkedin.com/in/diogo-lages-trindade-7249814b/",
				new Contact("Diogo Lages", "https://www.linkedin.com/in/diogo-lages-trindade-7249814b/", "diogolages@gmail.com"),
				"Permitido uso", "https://www.linkedin.com/in/diogo-lages-trindade-7249814b/", Collections.emptyList()
		);
	}
}
