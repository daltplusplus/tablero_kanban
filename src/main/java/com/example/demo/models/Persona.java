package com.example.demo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Setter
	@OneToMany()
	@JoinColumn(name = "persona_id")
	private List<Tablero> tableros = new ArrayList<>();

	public Persona(String nombre){
		this.nombre = nombre;
	}

	public Persona(){}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void addTablero(Tablero tablero) {
		tableros.add(tablero);
	}
}
