package com.example.demo.controllers;

import com.example.demo.models.Item;
import com.example.demo.models.Lista;
import com.example.demo.services.ListaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/listas")
public class ListaController {
	@Autowired
	private ListaService listaService;

	@PostMapping("/tablero/{tableroId}")
	public Lista crearLista(@PathVariable Long tableroId, @RequestBody Lista lista) {
		return listaService.guardarLista(tableroId,lista);
	}

	@GetMapping
	public List<Lista> listarListas() {
		return listaService.obtenerListas();
	}

	@GetMapping("/{id}")
	public Lista obtenerLista(@PathVariable Long id) {
		return listaService.obtenerListaPorId(id);
	}

	@DeleteMapping("/{id}")
	public void eliminarItem(@PathVariable Long id) {
		listaService.eliminarLista(id);
	}
}
