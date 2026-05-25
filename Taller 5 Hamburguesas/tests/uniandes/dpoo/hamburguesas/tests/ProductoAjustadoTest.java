package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import uniandes.dpoo.hamburguesas.mundo.*;


public class ProductoAjustadoTest {
	
	
	//atributos
	private ProductoAjustado prodAjustado;
	private ProductoMenu prodBase;
	private Ingrediente mozzarella;
	private Ingrediente tomate;
	
	
	
	@BeforeEach  //se ejecuta antes de cada test. Es el GIVEN 
    void setUp()  throws Exception
    {
		prodBase = new ProductoMenu("corral", 14000);  
        prodAjustado = new ProductoAjustado(prodBase);  
        mozzarella = new Ingrediente("queso mozzarella", 2500);
        tomate = new Ingrediente("tomate", 1000);
    }
	
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	
	@Test  // escenario 1: cuando tenemos un producto, le agregamos un ingrediente y queremos saber el precio total
    public void testGetPrecio()
    {
        //WHEN
		prodAjustado.agregarIngrediente(mozzarella);
		int precio = prodAjustado.getPrecio();

        //THEN
        assertEquals(16500, precio, "No se recibió el precio correcto");
    }
	
	
	@Test  // escenario 2: cuando tenemos un producto, le eliminamos un ingrediente y queremos saber el precio total
    public void testGetPrecio_segundoCaso()
    {
		//WHEN
		prodAjustado.eliminarIngrediente(tomate);
		int precio = prodAjustado.getPrecio();

        //THEN
        assertEquals(14000, precio, "No se recibió el precio correcto");
    }
	 
	
	@Test  // escenario 3: cuando queremos generar una factura con ingredientes eliminados y agregados
    public void testGenerarTextoFactura()
    {
		//WHEN
		prodAjustado.agregarIngrediente(mozzarella);
		prodAjustado.eliminarIngrediente(tomate);
		String factura = prodAjustado.generarTextoFactura();

        //THEN
		String esperada = "corral\n" + 
			              "            14000\n" +
			              "    +queso mozzarella" + 
			              "                2500" +
			              "    -tomate" + 
			              "            16500\n";
		
		
	    assertEquals(esperada, factura, "La factura que se recibe no es la esperada");
    }

}
