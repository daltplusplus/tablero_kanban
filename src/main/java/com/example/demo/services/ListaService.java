package com.example.demo.services;

import com.example.demo.models.Lista;

import com.example.demo.models.Tablero;
import com.example.demo.repositories.ListaRepository;
import com.example.demo.repositories.TableroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListaService {

	@Autowired
	private ListaRepository listaRepository;

	@Autowired
	private TableroRepository tableroRepository;

	@Transactional
	public Lista guardarLista(Long tableroId, Lista lista) {
		Tablero tablero = tableroRepository.findById(tableroId)
				.orElseThrow(() -> new RuntimeException("Tablero no encontrado"));

		tablero.addLista(lista);
		listaRepository.save(lista);
		tableroRepository.save(tablero);
		return lista;
	}

	public List<Lista> obtenerListas() {
		return listaRepository.findAll();
	}

	public Lista obtenerListaPorId(Long id) {
		return listaRepository.findById(id).orElse(null);
	}

	public void eliminarLista(Long id){
		listaRepository.deleteById(id);
	}
}
