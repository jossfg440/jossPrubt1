/*
 * Clase Producto.java 21 de ago. de 2019
 * Copyright 2019 jossfg440
 * 
 */
package ec.tod1.modelo;

import java.math.BigDecimal;
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
* Clase que representa la tabla PRODUCTO
*
* @author jossfg440
*/

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCTO")
	@SequenceGenerator(name = "SEQ_PRODUCTO", sequenceName = "SEQ_PRODUCTO", allocationSize = 1)
	@Column(name = "CODIGO_PRODUCTO")
	private Long codigoProducto;
	
	@Column(name = "CODIGO_TIPO_PRODUCTO")
	private Long codigoTipoProducto;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "PRECIO")
	private BigDecimal precio; 
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "CANTIDAD")
	private Integer cantidad;

 
    @ManyToOne(targetEntity = TipoProducto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_TIPO_PRODUCTO", insertable = false, updatable = false, nullable = true)
    private TipoProducto tipoProducto;


	
	public Long getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	public Long getCodigoTipoProducto() {
		return codigoTipoProducto;
	}


	public void setCodigoTipoProducto(Long codigoTipoProducto) {
		this.codigoTipoProducto = codigoTipoProducto;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}


	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	

}