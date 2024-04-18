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

import com.hdz.carr.app.jpa.models.Producto;
import com.hdz.carr.app.jpa.services.IService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	IService <Producto,Producto> productosServices;
	
	@PostMapping
	public Map<String,String> guardar(@RequestBody Producto c){
		productosServices.guardar(c);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Producto guardado!");
		return respuesta;
	}
	
	@GetMapping
	public List<Producto> listar(){
		return productosServices.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Producto obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Producto> producto = productosServices.getById(id);
		if (producto.isPresent()) {
			return producto.get();		
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id") Long id){
		productosServices.eliminar(id);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Producto eliminado!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Producto c, @PathVariable(name = "id") Long id){
		Optional<Producto> producto = productosServices.getById(id);
		if (producto.isPresent()) {
			c.setId(id);
			productosServices.guardar(c);
		}else {
			throw new RuntimeException("El producto no existe en la BD");
		}
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "producto actualizado!");
		return respuesta;
	}

}
