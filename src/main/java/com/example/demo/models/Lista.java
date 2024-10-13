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
@Table(name = "lista")
public class Lista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Setter
	@Column(name = "nombre")
	private String nombre;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "lista_id")
	private List<Item> items = new ArrayList<>();

	public Lista(){

	}

	public Lista(String nombre){
			this.nombre = nombre;
	}

	public void addItem(Item item){
		items.add(item);
	}
}
