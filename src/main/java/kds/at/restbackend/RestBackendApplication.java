package kds.at.restbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class RestBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestBackendApplication.class, args);
	}

	@Bean
	public ObjectMapper jacksonMapper() {
		return new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
	}


	// connect Swagger: see https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
	// 4.1. Java Configuration
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				// default for all RequestHandler controllers
				.apis(RequestHandlerSelectors.any())
				// default for all Paths
				.paths(PathSelectors.any())
				.build();

	}
}
