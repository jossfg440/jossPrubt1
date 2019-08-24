/**
 * Clase OrdenDao.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */

package ec.tod1.logica.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.tod1.logica.util.PersistenciaDao;
import ec.tod1.modelo.Orden;



/**
 * Clase que permite el acceso a la entidad Orden
 *
 * @author jossfg440
 *
 */

@Stateless
public class OrdenDao extends PersistenciaDao<Orden, Long> {

    public OrdenDao() {
        super(Orden.class);
    }

    public OrdenDao(EntityManager em) {
        super(Orden.class, em);
    }

    
}
