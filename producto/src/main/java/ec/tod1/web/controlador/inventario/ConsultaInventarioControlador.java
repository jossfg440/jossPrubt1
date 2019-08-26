/**
 * Clase ConsultaInventarioControlador.java 22 de ago. de 2019
 */
package ec.tod1.web.controlador.inventario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import ec.tod1.logica.ProductoBean;
import ec.tod1.logica.TipoProductoBean;
import ec.tod1.logica.util.ConsultaExcepcion;
import ec.tod1.modelo.Producto;
import ec.tod1.modelo.TipoProducto;


/**
 *  Controla la consultas al Inventario de Productos
 *   @author jossfg440 
 */

@ViewScoped

@ManagedBean
public class ConsultaInventarioControlador implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ProductoBean productoBean;
	@Inject
	private TipoProductoBean tipoProductoBean;



	/**
	 * Variables de la forma crear inventario *
	 */

	
	private List<Producto> listaProductos;
	private List<TipoProducto> listaTipoProductos;
	private Producto producto ;
	private TipoProducto tipoProducto ;
	private Boolean modoConsulta;
	private Boolean primeraConsulta;

	private String codigoTipoProducto;

	
	

	/**
	 * * Constructor sin parámetros.
	 */
	public ConsultaInventarioControlador() {
		super();
		//init();
	}

	@PostConstruct
	public void init() {
		iniciarlizarVariables();
		iniciarlizarVariablesConsultaInventario();
	}
	
	 /**
     * * Permite inicializar las variables del controlador y realizar algunas *
     * cargas de listas iniciales
     */
    protected void iniciarlizarVariables() {
    	
        setProducto(new Producto());
        
       
        
    }

	public void limpiarConsulta() {
		setListaProductos(new ArrayList<Producto>());

	}

	public void regresarConsulta() {
		setModoConsulta(true);
	}
	
	
	public String crearProducto() {

		
		return "crear-producto.xhtml";
		
	}
	
	public String modificarProducto() {
		setModoConsulta(false);
		
		return "modificar-producto.xhtml";
		
	}
	
	
	
	public void consultar() {
       
      	
        try {
        	System.out.println("llgA"+ getCodigoTipoProducto());
        	
        	
             	
        	System.out.println("llg"+ getCodigoTipoProducto());
        	if ( null != getCodigoTipoProducto()  ) {
        		setListaProductos( productoBean
    					.obtenerListaProductoPorCodigoTipoProducto( Long.valueOf( getCodigoTipoProducto() ) ) )  ;
        		
        	}
        	
				
		} catch (ConsultaExcepcion e) {
			setListaProductos(null); 
			
		}
		
	
        
        setPrimeraConsulta(Boolean.FALSE);
	}

	public void nuevaConsulta() {
		iniciarlizarVariables();
		iniciarlizarVariablesConsultaInventario();
		setListaProductos(new ArrayList<Producto>());
	}

	/**
	 * * Permite inicializar las variables del controlador y realizar algunas *
	 * cargas de listas iniciales
	 */
	private void iniciarlizarVariablesConsultaInventario() {
		setPrimeraConsulta(Boolean.TRUE);
		if ( null != tipoProductoBean ) {
			System.out.println("llg");
			setListaTipoProductos( tipoProductoBean.obtenerTodos());
				
		} 
		
		setModoConsulta(true);
		
		setListaProductos(new ArrayList<Producto>());
		
		
	}


	public List<Producto> getListaProductos() {
		return listaProductos;
	}


	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Boolean getModoConsulta() {
		return modoConsulta;
	}


	public void setModoConsulta(Boolean modoConsulta) {
		this.modoConsulta = modoConsulta;
	}


	public Boolean getPrimeraConsulta() {
		return primeraConsulta;
	}


	public void setPrimeraConsulta(Boolean primeraConsulta) {
		this.primeraConsulta = primeraConsulta;
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

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	

}
