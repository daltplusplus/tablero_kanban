package com.example.demo.services;

import com.example.demo.models.Persona;
import com.example.demo.models.Tablero;
import com.example.demo.repositories.PersonaRepository;
import com.example.demo.repositories.TableroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableroService {

	@Autowired
	private TableroRepository tableroRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Transactional
	public Tablero crearTablero(Long personaId, Tablero tablero) {
		Persona persona = personaRepository.findById(personaId)
				.orElseThrow(() -> new RuntimeException("Persona no encontrada"));

		persona.addTablero(tablero);

		tableroRepository.save(tablero);

		personaRepository.save(persona);

		return tablero;
	}


	public List<Tablero> obtenerTableros() {
		return tableroRepository.findAll();
	}

	public void borrarTablero(Long id){
		tableroRepository.deleteById(id);
	}

	public Tablero obtenerTableroPorId(Long id) {
		return tableroRepository.findById(id).orElse(null);
	}
}

