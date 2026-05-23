package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import uniandes.dpoo.hamburguesas.mundo.*;


public class PedidoTest {
	
	
	//atributos
	private Pedido pedido;
    private ProductoMenu corral;
    private ProductoMenu papasMedianas;

    
    @BeforeEach   //se ejecuta antes de cada test. Es el GIVEN
    public void setUp()
    {
        pedido = new Pedido("Juan", "Calle 123");
        corral = new ProductoMenu("corral", 14000);
        papasMedianas = new ProductoMenu("papas medianas", 5500);
    }
	
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }

	
	@Test  // escenario 1: cuando tenemos un pedido con un solo producto y queremos el precio
    public void testGetPrecioTotalPedido_un_producto()
    {
        //WHEN
        pedido.agregarProducto(corral);
        int total = pedido.getPrecioTotalPedido();

        //THEN
        assertEquals(16660, total);
    }

	
	
    @Test  // escenario 2: cuando tenemos un pedido con varios  y queremos el precio
    public void testGetPrecioTotalPedido_varios_productos()
    {
    	    //WHEN
        pedido.agregarProducto(corral);
        pedido.agregarProducto(papasMedianas);
        int total = pedido.getPrecioTotalPedido();

        //THEN
        assertEquals(23205, total);
    }

    
 
    @Test  // escenario 3: cuando tenemos un pedido con un producto y queremos generar la factura
    public void testGenerarTextoFactura()
    {
    	    //WHEN
        pedido.agregarProducto(corral);
        String factura = pedido.generarTextoFactura();

        //THEN
        String esperado = "Cliente: Juan\n" +
                          "Dirección: Calle 123\n" +
                          "----------------\n" +
                          "corral\n" +
                          "            14000\n" +
                          "----------------\n" +
                          "Precio Neto:  14000\n" +
                          "IVA:          2660\n" +
                          "Precio Total: 16660\n";
        
        assertEquals(esperado, factura);
    }
	
	
}
