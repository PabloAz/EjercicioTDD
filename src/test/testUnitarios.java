package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import domain.ejercicioTDD;

public class testUnitarios {

	@Test
	public void cadenaVacia() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		resultado = ejer.calcularFecha("");
		assertEquals("Error", resultado);
	}
	
	@Test
	public void formatoCorrecto1() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		resultado = ejer.calcularFecha("08/34/2000");
		assertTrue("Error".equals(resultado));
		
	}
	
	@Test
	public void formatoCorrecto2() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		
		resultado = ejer.calcularFecha("06/87");
		assertTrue("Error".equals(resultado));
		
	}
	
	@Test
	public void formatoCorrecto3() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		
		resultado = ejer.calcularFecha("06:87:67");
		assertTrue("Error".equals(resultado));
		
	}
	
	
	@Test
	public void longitudCorrecta1() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		
		resultado = ejer.calcularFecha("06/2003/2001");
		assertTrue("Error".equals(resultado));
		
	}
	
	
	@Test
	public void longitudCorrecta2() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		
		resultado = ejer.calcularFecha("06/200/2001");
		assertTrue("Error".equals(resultado));
	}
	
	@Test
	public void longitudCorrecta3() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		
		resultado = ejer.calcularFecha("06/200/01");
		assertTrue("Error".equals(resultado));
	}
	
	@Test
	public void longitudCorrecta4() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		
		resultado = ejer.calcularFecha("06/20034/02");
		assertTrue("Error".equals(resultado));
		
	}
	
	
	
	@Test
	public void fechaPosible() throws ParseException {
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		
		resultado = ejer.calcularFecha("06/20034/02");
		assertTrue("Error".equals(resultado));
		
	}
	
	@Test
	public void formarFechaTest(){
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		resultado = ejer.formarFecha("1", "1", "1");
		assertTrue("01/01/2001".equals(resultado));
		
	}
	
	@Test
	public void formarFechaTest2(){
		
		String resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		resultado = ejer.formarFecha("1", "1", "41");
		assertTrue("01/01/2041".equals(resultado));
		
	}
	
	@Test
	public void arrayFechasTest() throws ParseException{
		
		
		String[] fecha = {"1","1","1"};
		List<Calendar> resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		resultado = ejer.arrayFechas(ejer.generarFechas(fecha));
		assertTrue(resultado.size()==6);
		
	}
	
	@Test
	public void arrayFechasTest2() throws ParseException{
		
		
		String[] fecha = {"1","2004","2"};
		List<Calendar> resultado;
		ejercicioTDD ejer = new ejercicioTDD();
		resultado = ejer.arrayFechas(ejer.generarFechas(fecha));
		assertTrue(resultado.size()==2);
		
	}

	
	

}
