package com.hdz.carr.app.jpa.dao;
import org.springframework.data.repository.CrudRepository;
import com.hdz.carr.app.jpa.models.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long> {
		
	
}
