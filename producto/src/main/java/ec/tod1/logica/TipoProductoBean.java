/**
 * Clase TipoProductoBean.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */
package ec.tod1.logica;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.tod1.logica.dao.TipoProductoDao;
import ec.tod1.modelo.TipoProducto;

/**
 * Gestión de Tipo Producto
 *
 * @author jossfg440
 *
 */
@Stateless
public class TipoProductoBean {

    @Inject
    private TipoProductoDao tipoProductoDao;

    public TipoProductoBean() {
    }

    public TipoProductoBean(EntityManager em) {
    	tipoProductoDao = new TipoProductoDao(em);
    }
    
    public List<TipoProducto> obtenerTodos() {
    	return tipoProductoDao.obtenerTodos();
    	
    }
    
    public List<TipoProducto> obtenerListaTipoProducto()  {
    	return tipoProductoDao.obtenerListaTipoProducto();
    }
    

   

}
