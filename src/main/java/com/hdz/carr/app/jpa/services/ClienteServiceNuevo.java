package com.hdz.carr.app.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hdz.carr.app.jpa.models.Cliente;

@Service
@Qualifier("csNuevo") //identifica servicios que inyectan la misma dependencia
public class ClienteServiceNuevo implements IService<Cliente,Cliente> {

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void guardar(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
