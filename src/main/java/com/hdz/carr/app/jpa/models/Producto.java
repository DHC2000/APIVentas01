package com.hdz.carr.app.jpa.models;

import com.hdz.carr.app.jpa.enums.Categorias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpa_productos")
@Entity
public class Producto {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ2")
	@SequenceGenerator(sequenceName =  "customer_seq2",allocationSize = 1, name = "CUST_SEQ2")
	private Long id;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column(name = "descripcion")
	private String descripcion;
	
	//2
	@Column(name = "stock")
	private Integer stock;
	
	//2
	@Column(name = "precio")
	private Float precio;
	
	//2
	@Column(name = "categorias")
	private Categorias categorias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	
	
}
