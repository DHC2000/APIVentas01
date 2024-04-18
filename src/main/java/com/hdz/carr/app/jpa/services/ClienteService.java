package com.hdz.carr.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hdz.carr.app.jpa.dao.IClientesDao;
import com.hdz.carr.app.jpa.models.Cliente;

@Component
@Qualifier("csViejo")
public class ClienteService implements IService<Cliente,Cliente>{
	
	@Autowired
	private IClientesDao clienteDao;

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (List<Cliente>) clienteDao.findAll();
		return clientes;
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		// TODO Auto-generated method stub
		//return Optional.empty();
		Optional<Cliente> cliente = clienteDao.findById(id);
		return cliente;
	}

	@Override
	public void guardar(Cliente t) {
		// TODO Auto-generated method stub
		this.clienteDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.clienteDao.deleteById(id);
	}

}
