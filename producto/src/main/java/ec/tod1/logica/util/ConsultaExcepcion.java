/**
 * Clase ConsultaExcepcion.java 22 ago 2019
 */
package ec.tod1.logica.util;

import javax.ejb.ApplicationException;


/**
 * Personaliza excepciones en consultas
 * 
 * @author jossfg440∫
 *
 */
@ApplicationException(rollback = true, inherited = true)

public class ConsultaExcepcion extends RuntimeException {

	private static final long serialVersionUID = -8170481043533937658L;

	

	public ConsultaExcepcion() {
		super();
	}

	public ConsultaExcepcion(String msg, Object... params) {
		super(String.format(msg, params));
	}

	public ConsultaExcepcion(Exception e, String msg, Object... params) {
		super(String.format(msg, params), e);
	}

	public ConsultaExcepcion(Exception e) {
		super(e.getMessage(), e);
	}

	public ConsultaExcepcion(String msg, String argument) {
		super(String.format(msg, argument));
	}
}