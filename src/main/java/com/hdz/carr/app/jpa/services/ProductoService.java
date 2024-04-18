package com.hdz.carr.app.jpa.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdz.carr.app.jpa.dao.IProductosDao;
import com.hdz.carr.app.jpa.models.Producto;

@Service
public class ProductoService implements IService<Producto,Producto> {

	@Autowired
	private IProductosDao objDao;
	
	@Override
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<Producto>();
		productos = (List<Producto>) objDao.findAll();
		return productos;
	}

	@Override
	public Optional<Producto> getById(Long id) {
		Optional<Producto> producto = objDao.findById(id);
		return producto;
	}

	@Override
	public void guardar(Producto t) {
		this.objDao.save(t);		
	}

	@Override
	public void eliminar(Long id) {
		this.objDao.deleteById(id);		
	}

}
