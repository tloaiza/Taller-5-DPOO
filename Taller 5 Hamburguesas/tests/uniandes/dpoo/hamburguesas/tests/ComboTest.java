package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import uniandes.dpoo.hamburguesas.mundo.*;


public class ComboTest {
	
	
	//atributos
	private Combo combo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	
	@BeforeEach  //se ejecuta antes de cada test. Es el GIVEN
    void setUp()  throws Exception
    {
	    itemsCombo = new ArrayList<ProductoMenu>();
        itemsCombo.add(new ProductoMenu("corral", 14000));
        itemsCombo.add(new ProductoMenu("papas medianas", 5500));
        itemsCombo.add(new ProductoMenu("gaseosa", 5000));
        combo = new Combo("combo corral", 0.10, itemsCombo);
    }
	
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }

	
	/**
	 * escenario 1: cuando tenemos un combo corral el precio debe 
	 * tener el descuento asociado a este combo, siendo este el precio total
	 */
	
	@Test  
	public void testGetPrecio()
    {
        //WHEN
        int precio = combo.getPrecio();

        //THEN
        assertEquals(22050, precio, "No se recibió el precio esperado");
    }
	
	
	
	@Test  // escenario 2: cuando tenemos un combo corral, este debe ser el nombre recibido
    public void testGetNombre()
    {
		//WHEN
        String nombre = combo.getNombre();

        //THEN
        assertEquals("combo corral", nombre, "No se recibió el nombre esperado");
    }

	
	/**
	 * escenario 3: cuando tenemos un combo corral, cuando se ejecuta la factura
	 * este debe tener dicho nombre, su respectivo descuento y el precio total
	 * depues de haber aplicado el descuento
	 */
	
	@Test  
    public void testGenerarTextoFactura()
    {
		//WHEN
        String factura = combo.generarTextoFactura();

        //THEN
        String esperado = "Combo: combo corral\n" +
                          " Descuento: 0.1\n" +
                          "            22050\n";
        
        assertEquals(esperado, factura, "No se recibió la factura esperada");
    }
	
}
