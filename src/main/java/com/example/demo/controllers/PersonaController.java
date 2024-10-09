package com.example.demo.controllers;

import com.example.demo.models.Persona;
import com.example.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@PostMapping
	public Persona crearPersona(@RequestBody Persona persona) {
		return personaService.guardarPersona(persona);
	}

	@GetMapping
	public List<Persona> listarPersonas() {
		return personaService.obtenerPersonas();
	}

	@GetMapping("/{id}")
	public Persona obtenerPersona(@PathVariable Long id) {
		return personaService.obtenerPersonaPorId(id);
	}

	@DeleteMapping("/{id}")
	public void eliminarPersona(@PathVariable Long id) {
		personaService.eliminarPersona(id);
	}
}
