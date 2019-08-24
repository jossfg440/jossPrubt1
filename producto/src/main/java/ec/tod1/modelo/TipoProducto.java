/*
 * Clase TipoProducto.java 21 de ago. de 2019
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
* Clase que representa la tabla TIPO_PRODUCTO
*
* @author jossfg440
*/

@Entity
@Table(name = "TIPO_PRODUCTO")
public class TipoProducto {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_PRODUCTO")
	@SequenceGenerator(name = "SEQ_TIPO_PRODUCTO", sequenceName = "SEQ_TIPO_PRODUCTO", allocationSize = 1)
	@Column(name = "CODIGO_TIPO_PRODUCTO")
	private Long codigoTipoProducto;


	@Column(name = "DESCRIPCION")
	private String descripcion;


	public Long getCodigoTipoProducto() {
		return codigoTipoProducto;
	}


	public void setCodigoTipoProducto(Long codigoTipoProducto) {
		this.codigoTipoProducto = codigoTipoProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
