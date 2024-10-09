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

	public Tablero(){}

	public void addLista(Lista lista){
		listas.add(lista);
	}

	public Tablero(String nombre){
		this.nombre = nombre;
	}
}
