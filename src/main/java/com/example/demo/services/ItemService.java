package com.example.demo.services;

import com.example.demo.models.Item;
import com.example.demo.models.Lista;
import com.example.demo.models.Persona;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.ListaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ListaRepository listaRepository;
	
	@Transactional  // Maneja la transacción automáticamente
	public Item guardarItem(Long ListaId, Item item) {
		Lista lista = listaRepository.findById(ListaId)
				.orElseThrow(() -> new RuntimeException("Lista no encontrada"));

		lista.addItem(item);
		itemRepository.save(item);
		listaRepository.save(lista);
		return item;
	}

	public List<Item> obtenerItems() {
		return itemRepository.findAll();
	}

	public Item obtenerItemPorId(Long id) {
		return itemRepository.findById(id).orElse(null);
	}

	@Transactional
	public void eliminarItem(Long id){
		itemRepository.deleteById(id);
	}
}
