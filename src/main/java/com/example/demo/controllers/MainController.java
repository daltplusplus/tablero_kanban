package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model) {
		// Agrega atributos al modelo si es necesario
		model.addAttribute("mensaje", "¡Bienvenido a tu aplicación Kanban!");
		return "index"; // Esto devolverá index.html en la carpeta templates
	}
}
