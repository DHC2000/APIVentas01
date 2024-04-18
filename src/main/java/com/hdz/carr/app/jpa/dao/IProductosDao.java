package com.hdz.carr.app.jpa.dao;
import org.springframework.data.repository.CrudRepository;
import com.hdz.carr.app.jpa.models.Producto;

public interface IProductosDao extends CrudRepository<Producto,Long> {

}
