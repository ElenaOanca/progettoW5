package it.epicode.progettoW5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class ProgettoW5Application implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Server running...");








	}


	public static void main(String[] args) {
		SpringApplication.run(ProgettoW5Application.class, args);
	}

}
