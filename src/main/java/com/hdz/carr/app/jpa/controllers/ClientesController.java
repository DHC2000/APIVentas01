package com.hdz.carr.app.jpa.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdz.carr.app.jpa.models.Cliente;
import com.hdz.carr.app.jpa.services.ClienteService;
import com.hdz.carr.app.jpa.services.ClienteServiceNuevo;
import com.hdz.carr.app.jpa.services.IService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClientesController {

	//atributo
	//sin inversion de dependecias (no utilizar intergaces)
	//IService<Cliente,Cliente> clientesServices;
	
	/*public ClientesController(ClienteService cs) {
		//estos serian sin inyeccion de dependencias
		clientesServices = cs;  
	}*/
	
	//inyeccion de dependencia
	@Autowired
	@Qualifier("csViejo")
	IService<Cliente,Cliente> clientesServices;

	
	@PostMapping
	public Map<String,String> guardar(@RequestBody Cliente c){
		clientesServices.guardar(c);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Cliente guardado!");
		return respuesta;
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return clientesServices.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Cliente obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Cliente> cliente = clientesServices.getById(id);
		if (cliente.isPresent()) {
			return cliente.get();		
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id") Long id){
		clientesServices.eliminar(id);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Cliente eliminado!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Cliente c, @PathVariable(name = "id") Long id){
		Optional<Cliente> cliente = clientesServices.getById(id);
		if (cliente.isPresent()) {
			c.setId(id);
			clientesServices.guardar(c);
		}else {
			throw new RuntimeException("El cliente no existe en la BD");
		}
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Cliente actualizado!");
		return respuesta;
	}
}
