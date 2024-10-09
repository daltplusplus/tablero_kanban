package com.example.demo.services;

import com.example.demo.models.Persona;
import com.example.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	@Transactional
	public Persona guardarPersona(Persona persona) {
		return personaRepository.save(persona);
	}

	public List<Persona> obtenerPersonas() {
		return personaRepository.findAll();
	}

	public Persona obtenerPersonaPorId(Long id) {
		return personaRepository.findById(id).orElse(null);
	}

	@Transactional
	public void eliminarPersona(Long id) {
		personaRepository.deleteById(id);
	}
}
