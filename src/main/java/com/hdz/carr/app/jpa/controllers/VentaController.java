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

import com.hdz.carr.app.jpa.dtos.VentaDTO;
import com.hdz.carr.app.jpa.models.Venta;
import com.hdz.carr.app.jpa.services.IService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
	
	@Autowired
	private IService<Venta,VentaDTO> ventasServices;
	
	@PostMapping
	public Map<String,String> guardar(@RequestBody VentaDTO c){
		ventasServices.guardar(c);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Venta guardado!");
		return respuesta;
	}
	
	@GetMapping
	public List<Venta> listar(){
		return ventasServices.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Venta obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Venta> venta = ventasServices.getById(id);
		if (venta.isPresent()) {
			return venta.get();		
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id") Long id){
		ventasServices.eliminar(id);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Venta eliminada!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody VentaDTO c, @PathVariable(name = "id") Long id){
		Optional<Venta> venta = ventasServices.getById(id);
		if (venta.isPresent()) {
			c.setId(id);
			ventasServices.guardar(c);
		}else {
			throw new RuntimeException("La venta no existe en la BD");
		}
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Venta actualizada!");
		return respuesta;
	}

}
