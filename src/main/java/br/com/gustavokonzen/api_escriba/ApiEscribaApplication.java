package br.com.gustavokonzen.api_escriba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiEscribaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEscribaApplication.class, args);
    }

}
