package com.hdz.carr.app.jpa.dtos;

public class DetalleVentaDTO {

	private Long id;
	private Integer cantidad;
	private Long producto;
	private Long venta;
	
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
	public Long getProducto() {
		return producto;
	}
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	public Long getVenta() {
		return venta;
	}
	public void setVenta(Long venta) {
		this.venta = venta;
	}
	
	
}
