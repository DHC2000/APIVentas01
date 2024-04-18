package com.hdz.carr.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdz.carr.app.jpa.dtos.DetalleVentaDTO;
import com.hdz.carr.app.jpa.models.DetalleVenta;
import com.hdz.carr.app.jpa.services.IService;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {

	@Autowired
	private IService<DetalleVenta,DetalleVentaDTO> detalleVentasServices;
	
	@PostMapping
	public Map<String,String> guardar(@RequestBody DetalleVentaDTO c){
		detalleVentasServices.guardar(c);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Detalle de Venta guardado!");
		return respuesta;
	}
	
	@GetMapping
	public List<DetalleVenta> listar(){
		return detalleVentasServices.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public DetalleVenta obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<DetalleVenta> venta = detalleVentasServices.getById(id);
		if (venta.isPresent()) {
			return venta.get();		
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id") Long id){
		detalleVentasServices.eliminar(id);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Detalle de Venta eliminado!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody DetalleVentaDTO c, @PathVariable(name = "id") Long id){
		Optional<DetalleVenta> venta = detalleVentasServices.getById(id);
		if (venta.isPresent()) {
			c.setId(id);
			detalleVentasServices.guardar(c);
		}else {
			throw new RuntimeException("El detalle de la venta no existe en la BD");
		}
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Detalle de Venta actualizado!");
		return respuesta;
	}


}
