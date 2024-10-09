package com.example.demo.controllers;

import com.example.demo.models.Tablero;
import com.example.demo.services.TableroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tablero")
public class TableroController {

	@Autowired
	private TableroService tableroService;

	@PostMapping("/persona/{personaId}")
	public Tablero crearTablero(@PathVariable Long personaId, @RequestBody Tablero tablero){
		return tableroService.crearTablero(personaId, tablero);
	}
}
