package com.fitBeat.Products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.fitBeat.Database")
@ComponentScan({"com.fitBeat.Commons","com.fitBeat.CommonServices",
	"com.fitBeat.Controller","com.fitBeat.Database","com.fitBeat.DTO","com.fitBeat.Service",
		"com.fitBeat.ServiceImpl"})
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
		
		System.out.println("Welcome to Products Module ...");
	}

}
