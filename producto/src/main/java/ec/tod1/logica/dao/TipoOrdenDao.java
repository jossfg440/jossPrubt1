/**
 * Clase TipoOrdenDao.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */

package ec.tod1.logica.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.tod1.logica.util.PersistenciaDao;
import ec.tod1.modelo.TipoOrden;


/**
 * Clase que permite el acceso a la entidad TipoOrden
 *
 * @author jossfg440
 *
 */

@Stateless
public class TipoOrdenDao extends PersistenciaDao<TipoOrden, Long> {

    public TipoOrdenDao() {
        super(TipoOrden.class);
    }

    public TipoOrdenDao(EntityManager em) {
        super(TipoOrden.class, em);
    }

    
}
