/**
 * Clase TipoProductoDao.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */

package ec.tod1.logica.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.tod1.logica.util.ConsultaExcepcion;
import ec.tod1.logica.util.PersistenciaDao;
import ec.tod1.modelo.Producto;
import ec.tod1.modelo.TipoProducto;



/**
 * Clase que permite el acceso a la entidad TipoProducto
 *
 * @author jossfg440
 *
 */

@Stateless
public class TipoProductoDao extends PersistenciaDao<TipoProducto, Long> {

    public TipoProductoDao() {
        super(TipoProducto.class);
    }

    public TipoProductoDao(EntityManager em) {
        super(TipoProducto.class, em);
    }
    
    /**
     * @param codigoTipoProducto  Corresponde código de tipo de producto
     * 
     * 					
     * @return List<Producto> retorna el listado de productos
     * @throws Exception 
     */
    public List<TipoProducto> obtenerListaTipoProducto()  {
  	 
  	  String cadenaConsulta;
  	  cadenaConsulta = "SELECT e FROM TipoProducto e ";
  	  tipoConsulta = em.createQuery(cadenaConsulta, TipoProducto.class);
  	 
  	 

  	  List<TipoProducto> listaTipoProducto = tipoConsulta.getResultList();
  	  if (listaTipoProducto.isEmpty()) {

  		  throw new ConsultaExcepcion("NO existen registros para codigo: " );

  	  }

  	  return listaTipoProducto;

      
    }


    
}
