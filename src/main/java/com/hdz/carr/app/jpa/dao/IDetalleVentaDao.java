package com.hdz.carr.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import com.hdz.carr.app.jpa.models.DetalleVenta;

public interface IDetalleVentaDao extends CrudRepository<DetalleVenta, Long> {

}
