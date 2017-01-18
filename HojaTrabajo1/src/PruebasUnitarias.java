/**
 * PruebasUnitarias.java
 * Universidad del Valle de Guatemala
 * @since 1/17/2017
 * @author FER ESTRADA 14198 & CHRISTOPHER SANDOVAL 13660 
 * Hoja de Trabajo 1. Algoritmos y Estructura de Datos (k)
 * Pruebas unitarias a los metodos
 */



import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class PruebasUnitarias {

	@Test
	/**
	 * Test de cambio de estado de la radio
	 */
	public void test1() {
		RadioCool miRadio = new RadioCool();
		boolean estadoInicial = miRadio.getEstado();
		miRadio.estado();
		boolean estadoFinal = miRadio.getEstado();
		
		assertThat("Se prueba que el metodo estado si cambie el estado de el radio", estadoFinal, not(estadoInicial));
	}
	
	@Test
	/**
	 * Test de guardado de emisora
	 */
	public void test2() {
		RadioCool miRadio = new RadioCool();
		miRadio.estado();
		float emisoraPorGuardar = miRadio.getEmisora();
		miRadio.guardar(0);
		for (int i = 0; i<10; i++) {
			miRadio.cambiar(true);
		}
		miRadio.seleccionar(0);
		
		assertEquals("Se prueba si se guarda la emisora", emisoraPorGuardar, miRadio.getEmisora(), 0.01);
	}
	
	@Test
	/**
	 * Test cambio de emisora
	 */
	public void test3() {
		RadioCool miRadio = new RadioCool();
		miRadio.estado();
		float emisoraInicial = miRadio.getEmisora();
		miRadio.cambiar(true);
		
		assertEquals("Se prueba si se suma la cantidad correcta", miRadio.getEmisora(), emisoraInicial+10, 0.01);
	}
}