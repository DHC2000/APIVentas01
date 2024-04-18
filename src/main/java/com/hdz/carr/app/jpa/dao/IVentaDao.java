package com.hdz.carr.app.jpa.dao;
import org.springframework.data.repository.CrudRepository;
import com.hdz.carr.app.jpa.models.Venta;

public interface IVentaDao extends CrudRepository<Venta,Long>{
	
}
