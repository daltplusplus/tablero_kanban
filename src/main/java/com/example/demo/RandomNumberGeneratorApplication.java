package com.example.demo;


import com.example.demo.models.Persona;
import com.example.demo.services.PersonaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class RandomNumberGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomNumberGeneratorApplication.class, args);
		/*PersonaService personaService = new PersonaService();
		Persona persona = new Persona("Dante Lopez");
		personaService.guardarPersona(persona);
		*/
	}

}
