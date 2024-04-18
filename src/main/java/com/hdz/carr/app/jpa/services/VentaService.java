package com.hdz.carr.app.jpa.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdz.carr.app.jpa.dao.IClientesDao;
import com.hdz.carr.app.jpa.dao.IVentaDao;
import com.hdz.carr.app.jpa.dtos.VentaDTO;
import com.hdz.carr.app.jpa.models.Venta;

@Service
public class VentaService implements IService<Venta,VentaDTO>{

	@Autowired
	private IVentaDao objDao;
	
	@Autowired
	private IClientesDao clientesDao;
	@Override
	public List<Venta> listar() {
		List<Venta> venta = new ArrayList<Venta>();
		venta = (List<Venta>) objDao.findAll();
		return venta;
	}

	@Override
	public Optional<Venta> getById(Long id) {
		Optional<Venta> venta = objDao.findById(id);
		return venta;
	}

	@Override
	public void guardar(VentaDTO t) {
		this.objDao.save(convertirDTOaVenta(t));				
	}

	@Override
	public void eliminar(Long id) {
		this.objDao.deleteById(id);		
	}
	
	//convertir el  modelo original
	public Venta convertirDTOaVenta(VentaDTO ventadto) {
		Venta v =  new Venta();
			v.setId(ventadto.getId());
			v.setFecha(ventadto.getFecha());
			v.setSubtotal(ventadto.getSubtotal());
			v.setTotal(ventadto.getTotal());
			v.setDescuento(ventadto.getDescuento());
			v.setFormaPago(ventadto.getFormaPago());
			v.setCliente(clientesDao.findById(ventadto.getCliente()).get());
			return v;
		}
}
