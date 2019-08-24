/**
 * Clase OrdenBean.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */
package ec.tod1.logica;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.tod1.logica.dao.OrdenDao;

/**
 * Gestión de Orden
 *
 * @author jossfg440
 *
 */
@Stateless
public class OrdenBean {

    @Inject
    private OrdenDao ordenDao;

    public OrdenBean() {
    }

    public OrdenBean(EntityManager em) {
    	ordenDao = new OrdenDao(em);
    }

   

}
