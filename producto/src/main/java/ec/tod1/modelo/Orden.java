/*
 * Clase Orden.java 21 de ago. de 2019
 * Copyright 2019 jossfg440
 * 
 */
package ec.tod1.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
* Clase que representa la tabla ORDEN
*
* @author jossfg440
*/

@Entity
@Table(name = "ORDEN")
public class Orden {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORDEN")
	@SequenceGenerator(name = "SEQ_ORDEN", sequenceName = "SEQ_ORDEN", allocationSize = 1)
	@Column(name = "CODIGO_ORDEN")
	private Long codigoOrden;
	
	@Column(name = "CODIGO_TIPO_ORDEN")
	private Long codigoTipoOrden;
	

	@Column(name = "CODIGO_PRODUCTO")
	private Long codigoProducto;
	
	@Column(name = "CANTIDAD_ORDEN")
	private Long cantidadOrden;
	
	@Column(name = "FECHA_ORDEN")
	private Date fecha_orden;

 
	@ManyToOne(targetEntity = TipoProducto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_TIPO_ORDEN", insertable = false, updatable = false, nullable = true)
    private TipoOrden tipoOrden;
	
	@ManyToOne(targetEntity = TipoProducto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_PRODUCTO", insertable = false, updatable = false, nullable = true)
    private Producto producto;
	


	public Long getCodigoOrden() {
		return codigoOrden;
	}


	public void setCodigoOrden(Long codigoOrden) {
		this.codigoOrden = codigoOrden;
	}


	public Long getCodigoTipoOrden() {
		return codigoTipoOrden;
	}


	public void setCodigoTipoOrden(Long codigoTipoOrden) {
		this.codigoTipoOrden = codigoTipoOrden;
	}



	public Long getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public Long getCantidadOrden() {
		return cantidadOrden;
	}


	public void setCantidadOrden(Long cantidadOrden) {
		this.cantidadOrden = cantidadOrden;
	}


	public Date getFecha_orden() {
		return fecha_orden;
	}


	public void setFecha_orden(Date fecha_orden) {
		this.fecha_orden = fecha_orden;
	}


	public TipoOrden getTipoOrden() {
		return tipoOrden;
	}


	public void setTipoOrden(TipoOrden tipoOrden) {
		this.tipoOrden = tipoOrden;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	
	
	

}
