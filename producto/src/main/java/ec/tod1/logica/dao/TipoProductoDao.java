/**
 * Clase TipoProductoDao.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */

package ec.tod1.logica.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ec.tod1.logica.util.PersistenciaDao;
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

    
}
