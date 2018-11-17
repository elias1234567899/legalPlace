package com.legalPlace.legalPlace;

import com.legalPlace.dao.TodoRepository;
import com.legalPlace.model.Todo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.legalPlace.dao")
@EntityScan("com.legalPlace.model")
@ComponentScan("com.legalPlace.controller")
@SpringBootApplication
public class LegalPlaceApplication {

    
	public static void main(String[] args) {
		SpringApplication.run(LegalPlaceApplication.class, args);
	}

  
}
