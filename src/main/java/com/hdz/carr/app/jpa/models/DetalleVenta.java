package com.hdz.carr.app.jpa.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpa_detalle_ventas")
@Entity
public class DetalleVenta {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ4")
	@SequenceGenerator(sequenceName =  "customer_seq4",allocationSize = 1, name = "CUST_SEQ4")
	private Long id;
	
	//2
	@Column(name = "cantidad")
	private Integer cantidad;
	
	//3
	@JoinColumn(name = "producto_id")
	@ManyToOne
	private Producto producto;
	
	//3
	@JoinColumn(name = "venta_id")
	@ManyToOne
	private Venta venta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
