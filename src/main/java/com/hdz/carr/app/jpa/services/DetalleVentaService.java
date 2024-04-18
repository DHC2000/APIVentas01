package com.hdz.carr.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdz.carr.app.jpa.dao.IDetalleVentaDao;
import com.hdz.carr.app.jpa.dao.IProductosDao;
import com.hdz.carr.app.jpa.dao.IVentaDao;
import com.hdz.carr.app.jpa.dtos.DetalleVentaDTO;
import com.hdz.carr.app.jpa.models.DetalleVenta;

@Service  
public class DetalleVentaService implements IService<DetalleVenta,DetalleVentaDTO> {

	@Autowired
	private IDetalleVentaDao objDao;
	

	@Autowired
	private IProductosDao productosDao;
	
	@Autowired
	private IVentaDao ventasDao;
	
	@Override
	public List<DetalleVenta> listar() {
		List<DetalleVenta> detalleV = new ArrayList<DetalleVenta>();
		detalleV = (List<DetalleVenta>) objDao.findAll();
		return detalleV;
	}

	@Override
	public Optional<DetalleVenta> getById(Long id) {
		Optional<DetalleVenta> detalleV = objDao.findById(id);
		return detalleV;
	}

	@Override
	public void guardar(DetalleVentaDTO t) {
		this.objDao.save(convertirDTOaDetalleVentas(t));		
	}

	@Override
	public void eliminar(Long id) {
		this.objDao.deleteById(id);				
	}
	
	public DetalleVenta convertirDTOaDetalleVentas(DetalleVentaDTO detalleVentaDTO) {
		
		DetalleVenta dv = new DetalleVenta();
		dv.setCantidad(detalleVentaDTO.getCantidad());
		dv.setProducto(productosDao.findById(detalleVentaDTO.getProducto()).get()); 
		dv.setVenta(ventasDao.findById(detalleVentaDTO.getVenta()).get());
		return dv;
	}

}
