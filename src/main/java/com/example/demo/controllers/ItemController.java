package com.example.demo.controllers;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/lista/{listaId}")
	public Item crearItem(@PathVariable Long listaId, @RequestBody Item item) {
		return itemService.guardarItem(listaId,item);
	}

	@GetMapping
	public List<Item> listarItems() {
		return itemService.obtenerItems();
	}

	@GetMapping("/{id}")
	public Item obtenerItem(@PathVariable Long id) {
		return itemService.obtenerItemPorId(id);
	}

	@DeleteMapping("/{id}")
	public void eliminarItem(@PathVariable Long id) {
		itemService.eliminarItem(id);
	}
}
