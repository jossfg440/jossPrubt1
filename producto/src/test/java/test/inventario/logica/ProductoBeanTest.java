package test.inventario.logica;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ec.tod1.logica.ProductoBean;
import ec.tod1.modelo.Producto;
import ec.tod1.modelo.TipoProducto;

import org.junit.runners.MethodSorters;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductoBeanTest extends InicializaTest {
	
	private ProductoBean productoBean;
	private final Logger log = LoggerFactory.getLogger(ProductoBeanTest.class);
	Producto producto;
	Long codigoProducto;
	Long codigoTipoProducto;
	Integer cantidad;
	String descripcion;
	Date fecha;
	BigDecimal precio;
	
	TipoProducto tipoProducto;
	String descripcionTipo;
	
	
	
	
	@Before
	public void conf() {
		codigoProducto = 1L;
		cantidad = 50;
		String cadenaHoraInicio = "10/12/2019";
		DateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fecha = formatoHora.parse(cadenaHoraInicio);
		} catch (ParseException e) {
			 log.error("error format:" + e );
			
		}
		descripcion = "Camiseta";
		descripcionTipo = "Marvel";
		precio = new BigDecimal("1") ;
		
		
	
		
		
	}
	
	@Test
	public void deberiaObtenerListaProductoPorCodigoTipoProducto() {
		
		crearTipoProducto(descripcionTipo);
		System.out.println("d:" + tipoProducto.getCodigoTipoProducto()) ;
		crearProducto(descripcion,cantidad,precio,fecha,tipoProducto,tipoProducto.getCodigoTipoProducto());
		log.info("Cantidad:" + producto.getCantidad() );
		productoBean = new ProductoBean(entityManager);
		List<Producto> resultado = productoBean.obtenerListaProductoPorCodigoTipoProducto( tipoProducto.getCodigoTipoProducto() );
		
		Assert.assertEquals(resultado.size(), 1);
		
	}

	
	private void crearTipoProducto(String descripcionTipo2) {
		tipoProducto = new TipoProducto();
		tipoProducto.setDescripcion(descripcionTipo2);
		persistirObjetoInicial(tipoProducto);
		
	}
	
	private void crearProducto(String descripcion2, Integer cantidad2, BigDecimal precio2, Date fecha2,
			TipoProducto tipoProducto2, Long codigoTipoProducto) {
		producto = new Producto();
		producto.setCodigoTipoProducto(codigoTipoProducto);
		producto.setDescripcion(descripcion2);
		producto.setCantidad(cantidad2);
		producto.setPrecio(precio2);
		producto.setFecha(fecha2);
		producto.setTipoProducto(tipoProducto2);
		persistirObjeto(producto);

	}
	

}
