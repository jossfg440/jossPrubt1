/**
 * Clase ProductoBean.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */
package ec.tod1.logica;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.tod1.logica.dao.ProductoDao;
import ec.tod1.modelo.Producto;

/**
 * Gestión de Producto
 *
 * @author jossfg440
 *
 */
@Stateless
public class ProductoBean {

    @Inject
    private ProductoDao productoDao;

    public ProductoBean() {
    }

    public ProductoBean(EntityManager em) {
    	productoDao = new ProductoDao(em);
    }
    
    
    public Producto obtenerPorCodigo (Long codigoProducto ) {
    	return productoDao.obtenerPorCodigo(codigoProducto);
    }
    
    /**
     * @param codigoTipoProducto  Corresponde código de tipo de producto
     * 
     * 					
     * @return List<Producto> retorna el listado de productos
     * @throws Exception 
     */
    public List<Producto> obtenerListaProductoPorCodigoTipoProducto(Long codigoTipoProducto)  {
    	return productoDao.obtenerListaProductoPorCodigoTipoProducto(codigoTipoProducto);
    }
    
    
    

   

}
