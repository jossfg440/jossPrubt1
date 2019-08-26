/**
 * Clase CrearInventarioControlador.java 22 de ago. de 2019
 */
package ec.tod1.web.controlador.inventario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.tod1.logica.ProductoBean;
import ec.tod1.logica.TipoProductoBean;
import ec.tod1.modelo.Producto;
import ec.tod1.modelo.TipoProducto;


/**
 *  Administración Inventario
 *  @author jossfg440
 */
@ViewScoped
@ManagedBean
public class CrearInventarioControlador implements Serializable  {

    private static final long serialVersionUID = 1L;
    private final Logger log = LoggerFactory.getLogger(CrearInventarioControlador.class);
    
    
    @Inject
	private ProductoBean productoBean;
    @Inject
	private TipoProductoBean tipoProductoBean;
    
    
    private List<TipoProducto> listaTipoProductos;
    private String codigoTipoProducto;
    private Producto producto ;
    private String descripcion;
    private String precio;
    private String fecha;
    private String cantidad;
    
    
    

   

    /**
     * * Constructor sin parámetros.
     */
    public CrearInventarioControlador() {
        super();
    }
    
    @PostConstruct
    public void init() {        
        iniciarlizarVariablesLocales();
    }
    
  
    public String consultarProducto() {

		
		return "consulta.xhtml";
		
	} 
    
    
    
    public void guardar() {  
		try {
			    producto.setCodigoTipoProducto( Long.valueOf( getCodigoTipoProducto() ) );
			    producto.setDescripcion( getDescripcion() );
	
			   

			    productoBean.crear(producto);
			
		} catch (EJBException e) {
			 log.error("error al guardar:" + e );
			
		} 
		
        
    }
    
        
   
    
    
    
    /**
     * * Permite inicializar las variables del controlador y realizar algunas *
     * cargas de listas iniciales
     */
    private void iniciarlizarVariablesLocales() {
    	
    	if ( null != tipoProductoBean ) {
			System.out.println("llg");
			setListaTipoProductos( tipoProductoBean.obtenerTodos());
				
		} 
    	
        producto = new Producto();
    	
  	    setProducto( producto );
 	  
               
         
    }

	public List<TipoProducto> getListaTipoProductos() {
		return listaTipoProductos;
	}

	public void setListaTipoProductos(List<TipoProducto> listaTipoProductos) {
		this.listaTipoProductos = listaTipoProductos;
	}

	public String getCodigoTipoProducto() {
		return codigoTipoProducto;
	}

	public void setCodigoTipoProducto(String codigoTipoProducto) {
		this.codigoTipoProducto = codigoTipoProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
    
    

	
   
  

}
