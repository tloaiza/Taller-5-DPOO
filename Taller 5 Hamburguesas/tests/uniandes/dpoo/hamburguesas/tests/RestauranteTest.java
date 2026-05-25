package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;
import uniandes.dpoo.hamburguesas.excepciones.*;



public class RestauranteTest {

	
	//atributo
	private Restaurante restaurante;
	
	
	 @BeforeEach   //se ejecuta antes de cada test. Es el GIVEN 
	    public void setUp() throws Exception
	    {
	        restaurante = new Restaurante();
	        File archivoIngredientes = new File("./data/ingredientes.txt");
	        File archivoMenu = new File("./data/menu.txt");
	        File archivoCombos = new File("./data/combos.txt");
	        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
	    }
		
		
		@AfterEach
	    void tearDown( ) throws Exception
	    {
	    }
	
		
		
		@Test  // escenario 1: cuando queremos cargar la informacion del restaurante
	    public void testCargarInformacion()
	    {   
			//THEN
	        assertTrue(restaurante.getIngredientes().size() > 0, "No se cargó la información de los ingredientes correctamente");
	        assertTrue(restaurante.getMenuBase().size() > 0, "No se cargó la información del menú correctamente");
	        assertTrue(restaurante.getMenuCombos().size() > 0, "No se cargó la información del menú de combos correctamente");
	    }
		

	    @Test  // escenario 2: cuando queremos iniciar un pedido
	    public void testIniciarPedido() throws Exception
	    {    
	    	    //WHEN
	        restaurante.iniciarPedido("Juan", "Calle 123");
	        
	        //THEN
	        assertNotNull(restaurante.getPedidoEnCurso(), "El pedido no se inició correctamente");
	    }

	    
	    
	    @Test  // escenario 3: cuando iniciamos un pedido y ya hay uno en curso
	    public void testIniciarPedidoYaEnCurso() throws Exception
	    {   
	    	
	    	    //GIVEN
	        restaurante.iniciarPedido("Juan", "Calle 123");
	        
	        //WHEN + THEN
	        assertThrows(YaHayUnPedidoEnCursoException.class, () -> {restaurante.iniciarPedido("Pedro", "Calle 456");});
	    }

	    
	    @Test  // escenario 4: cuando queremos cerrar un pedido
	    public void testCerrarPedido() throws Exception
	    {
	    	    
	    	    //GIVEN
	    	    restaurante.iniciarPedido("Juan", "Calle 123");
	    	
	    	    //WHEN
	        restaurante.cerrarYGuardarPedido();
	        
	        //THEN
	        assertNull(restaurante.getPedidoEnCurso(), "El pedido no se cerró correctamente");
	    }

	    
	    
	    @Test  // escenario 5: cuando cerramos un pedido sin tener ninguno en curso
	    public void testCerrarPedidoSinPedidoEnCurso()
	    {   
	    	 
	    	    //WHEN + THEN
	        assertThrows(NoHayPedidoEnCursoException.class, () -> {restaurante.cerrarYGuardarPedido();});
	    }
}

