/**
 * Clase ModificarInventarioControlador.java 22 de ago. de 2019
 */
package ec.tod1.web.controlador.inventario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.tod1.logica.ProductoBean;
import ec.tod1.logica.TipoProductoBean;
import ec.tod1.modelo.Producto;
import ec.tod1.modelo.TipoProducto;


/**
 *  Modificación Inventario
 *  @author jossfg440
 */
@ViewScoped
@ManagedBean
public class ModificarInventarioControlador implements Serializable  {

    private static final long serialVersionUID = 1L;
    private final Logger log = LoggerFactory.getLogger(ModificarInventarioControlador.class);
    
    
    @Inject
	private ProductoBean productoBean;
    @Inject
	private TipoProductoBean tipoProductoBean;
    
    
    private List<TipoProducto> listaTipoProductos;
    private String codigoTipoProducto;
    private String codigoProducto;
    private Producto producto ;
    private String descripcion;
    private String precio;
    private String fecha;
    private String cantidad;
    private Boolean modoConsulta;
    
    
    

   

    /**
     * * Constructor sin parámetros.
     */
    public ModificarInventarioControlador() {
        super();
    }
    
    @PostConstruct
    public void init() {        
        iniciarlizarVariablesLocales();
    }
    
  
    public String consultarProducto() {

		
		return "consulta.xhtml";
		
	} 
    
    
    
    public void modificar() {  
		try {
			    
			 
			   log.info("d:" + producto.getCodigoProducto() + "d1:"+ producto.getDescripcion());
	
			   

			    productoBean.modificar(producto);
			    setModoConsulta(true);
			
		} catch (EJBException e) {
			 log.error("error al modificar:" + e );
			
		} 
		
        
    }
    
        
    public String obtenerParametroURL(final String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    } 
    
    
    
    /**
     * * Permite inicializar las variables del controlador y realizar algunas *
     * cargas de listas iniciales
     */
    private void iniciarlizarVariablesLocales() {
    	
    	setCodigoProducto(  obtenerParametroURL("codigoProducto") );
    	
    	if ( null != getCodigoProducto() ) {
			System.out.println("llg");
			setListaTipoProductos( tipoProductoBean.obtenerTodos());
			producto = productoBean.obtenerPorCodigo( Long.valueOf( codigoProducto ) );
				
		} 
    	
    	if ( null != tipoProductoBean ) {
			System.out.println("llg");
			setListaTipoProductos( tipoProductoBean.obtenerTodos());
				
		} 
    	
       // producto = new Producto();
    	
  	    setProducto( producto );
  	    setModoConsulta(false);
 	  
               
         
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

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Boolean getModoConsulta() {
		return modoConsulta;
	}

	public void setModoConsulta(Boolean modoConsulta) {
		this.modoConsulta = modoConsulta;
	}
	
	

   
  

}
