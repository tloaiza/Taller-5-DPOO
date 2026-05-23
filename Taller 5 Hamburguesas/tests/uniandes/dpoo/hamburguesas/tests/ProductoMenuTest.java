package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;


public class ProductoMenuTest {
      
	//atributos
	private ProductoMenu producto;
	
	
	/**
	 * Este before each se ejecuta antes de cada test. En este caso es el GIVEN de cada uno
	 * que es que se crea un producto llamado corral con un precio de 14000
	 */
	
	@BeforeEach  
	public void setUp()
    {
        producto = new ProductoMenu("corral", 14000);  
    }
	
	
	@AfterEach
    public void tearDown( ) throws Exception
    {
    }
	
	
	@Test  // escenario 1: cuando tenemos un producto y queremos saber su nombre
    public void testGetPrecio()
    {
        //WHEN
        int precio = producto.getPrecio();

        //THEN
        assertEquals(14000, precio, "No se recibió el precio correcto");
    }
	
	
	@Test  // escenario 2: cuando tenemos un producto y queremos saber su nombre
    public void testGetNombre()
    {
        //WHEN
        String nombre = producto.getNombre();

        //THEN
        assertEquals("corral", nombre, "No se recibió el nombres correcto");
    }
	
	
	@Test  // escenario 3: cuando queremos generar una factura
    public void testGenerarTextoFactura()
    {
        //WHEN
		String factura = producto.generarTextoFactura();

        //THEN
		String esperada = "corral\n" + 
                          "            " + 
				          "14000\n";
		
	    assertEquals(esperada, factura, "La factura que se recibe no es la esperada");
    }
	
	
	
}
