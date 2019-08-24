/**
 * Clase TipoOrdenBean.java 04 de may. de 2018
 * Copyright 2019 jossfg440
 */
package ec.tod1.logica;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.tod1.logica.dao.TipoOrdenDao;

/**
 * Gestión de Tipo Orden
 *
 * @author jossfg440
 *
 */
@Stateless
public class TipoOrdenBean {

    @Inject
    private TipoOrdenDao tipoOrdenDao;

    public TipoOrdenBean() {
    }

    public TipoOrdenBean(EntityManager em) {
    	tipoOrdenDao = new TipoOrdenDao(em);
    }

   

}
