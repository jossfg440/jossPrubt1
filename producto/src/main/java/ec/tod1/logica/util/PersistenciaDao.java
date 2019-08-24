package ec.tod1.logica.util;

import java.io.Serializable;
import java.util.List;

/**
*  Métodos generios para gestionar persistencia.
*
* @author jossfg440
*
*/

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class PersistenciaDao<E, C extends Serializable> {
	
	    @PersistenceContext(unitName = "InventarioPU")
	    protected EntityManager em;
	    protected TypedQuery<E> tipoConsulta;
	   
	   
	    private final Class<E> entidad;

	    /**
	     * Constructor
	     *
	     * @param entidad
	     */
	    public PersistenciaDao(final Class<E> entidad) {
	        this.entidad = entidad;
	    }

	    /**
	     * @param em
	     * @param entidad
	     */
	    public PersistenciaDao(final Class<E> entidad, final EntityManager em) {
	        this.entidad = entidad;
	        this.em = em;
	    }

	    /**
	     * Método genérico para insertar un registro
	     *
	     * @param entidad entidad a crear
	     */
	    public E crear(final E entidad) {
	        em.persist(entidad);
	        em.flush();
	        return entidad;
	    }

	    /**
	     * Método para actualizar un registro
	     *
	     * @param entidad entidad actualizar
	     * @return tabla de tipo entidad con registro modificado
	     */
	    public E modificar(final E entidad) {
	        return em.merge(entidad);
	    }

	    /**
	     * Método para eliminar un registro
	     *
	     * @param codigo código a eliminar
	     */
	    public void eliminar(final C codigo) {
	        E entidadEliminar = obtenerPorCodigo(codigo);
	        em.remove(entidadEliminar);
	        em.flush();

	    }
	    
	    /**
	     * Método para buscar un registro 
	     *
	     * @param codigo código registro buscar
	     * @return retorna entidad
	     */
	    public E obtenerPorCodigo(final C codigo) {
	        return em.find(entidad, codigo);
	    }
	    
	    
	    /**
	     * Método para recuperar todos los datos de una entidad
	     *
	     * @return lista de objetos de tipo entidad∫
	     */
	    public List<E> obtenerTodos() {
	        TypedQuery<E> consulta = em.createQuery("Select t from " + entidad.getSimpleName() + " t", entidad);
	        return consulta.getResultList();
	    }

	

}
