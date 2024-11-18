package com.ecommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:configMail.properties")  // accéder aux configuration du fichier configMail.proprerties
@SpringBootApplication
public class EcommercespringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercespringApplication.class, args);

	}

}
