/*
 * Clase TipoOrden.java 21 de ago. de 2019
 * Copyright 2019 jossfg440
 * 
 */
package ec.tod1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
* Clase que representa la tabla TIPO_ORDEN
*
* @author jossfg440
*/

@Entity
@Table(name = "TIPO_ORDEN")
public class TipoOrden {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_ORDEN")
	@SequenceGenerator(name = "SEQ_TIPO_ORDEN", sequenceName = "SEQ_TIPO_ORDEN", allocationSize = 1)
	@Column(name = "CODIGO_TIPO_ORDEN")
	private Long codigoTipoOrden;


	@Column(name = "DESCRIPCION")
	private String descripcion;



	public Long getCodigoTipoOrden() {
		return codigoTipoOrden;
	}


	public void setCodigoTipoOrden(Long codigoTipoOrden) {
		this.codigoTipoOrden = codigoTipoOrden;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
