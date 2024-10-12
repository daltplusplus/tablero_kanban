package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tablero")
public class Tablero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Setter
	@Getter
	@Column(name = "nombre")
	private String nombre;
	@Setter
	@OneToMany()
	@JoinColumn(name = "tablero_id")
	private List<Lista> listas = new ArrayList<>();

	@ManyToOne()
	private Persona creador;

	@ManyToMany()
	private List<Persona> autorizados;


	public Tablero(){}

	public void addLista(Lista lista){
		listas.add(lista);
	}

	public Tablero(String nombre){
		this.nombre = nombre;
	}

	public void addAutorizado(Persona persona){
		autorizados.add(persona);
	}

	public void setCreador(Persona creador) {
		this.creador = creador;
	}
}
