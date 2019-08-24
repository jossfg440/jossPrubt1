/**
 * Clase ProductoDao.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */

package ec.tod1.logica.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.tod1.logica.util.ConsultaExcepcion;
import ec.tod1.logica.util.PersistenciaDao;
import ec.tod1.modelo.Producto;




/**
 * Clase que permite el acceso a la entidad Producto
 *
 * @author jossfg440
 *
 */

@Stateless
public class ProductoDao extends PersistenciaDao<Producto, Long> {

    public ProductoDao() {
        super(Producto.class);
    }

    public ProductoDao(EntityManager em) {
        super(Producto.class, em);
    }
    
    /**
     * @param codigoTipoProducto  Corresponde código de tipo de producto
     * 
     * 					
     * @return List<Producto> retorna el listado de productos
     * @throws Exception 
     */
    public List<Producto> obtenerListaProductoPorCodigoTipoProducto(Long codigoTipoProducto)  {
  	 
  	  String cadenaConsulta;
  	  cadenaConsulta = "SELECT e FROM Producto e WHERE e.codigoTipoProducto = :codigoTipoProducto ";
  	  tipoConsulta = em.createQuery(cadenaConsulta, Producto.class);
  	  tipoConsulta.setParameter("codigoTipoProducto", codigoTipoProducto);
  	 

  	  List<Producto> listaProducto = tipoConsulta.getResultList();
  	  if (listaProducto.isEmpty()) {

  		  throw new ConsultaExcepcion("NO existen registros para codigo: " + codigoTipoProducto);

  	  }

  	  return listaProducto;

      
    }

    
}
