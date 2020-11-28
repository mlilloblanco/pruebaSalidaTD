package org.mlb.pruebaSalidaTD.comisiones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PruebasUnitariasComisiones {


	CalculadoraCompleja calculadoraCompleja = new CalculadoraCompleja();
	//mismos valores misma comision
	@Test
	public void validarValoresMenoresA5000() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(2000, 2000, 2000, 2000, 2000));
		assertEquals(500, calculadoraCompleja.calcula(listaVenta));
	}
	
	//mismos valores misma comision
	@Test
	public void validarValoresEntre5000Y1000() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(7500, 7500, 7500, 7500, 7500));
		assertEquals(2625, calculadoraCompleja.calcula(listaVenta));
	}
	
	//aqui se superan los 50000 en total asi que se suma un 1% de 62500 al 8% de 62500 (dando un 9% de comision)
	@Test
	public void validarValoresMayoresA10000() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(12500, 12500, 12500, 12500, 12500));
		assertEquals(5625, calculadoraCompleja.calcula(listaVenta));
	}
	
	//distintos valores misma comision
	@Test
	public void validarDistintasCantidades() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(12000, 11500, 13500, 14500, 15000));
		assertEquals(5985, calculadoraCompleja.calcula(listaVenta));
	}
	
	//distintas comisiones y bajo 50000
	@Test
	public void validarDistintasCantidadesConDistintaComision() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(4000, 5500, 6500, 14500, 15000));
		assertEquals(3400, calculadoraCompleja.calcula(listaVenta));
	}
	
	//distintas comisiones y sobre 50000
	@Test
	public void validarDistintasCantidadesConDistintaComisionSobre50000() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(4000, 5500, 6500, 14500, 20000));
		assertEquals(4305, calculadoraCompleja.calcula(listaVenta));
	}
	
	//condicion de borde 0
	@Test
	public void condicionDeBorde0() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, calculadoraCompleja.calcula(listaVenta));
	}
	
	//condicion de borde 0 con otros valores
	@Test
	public void condicionDeBorde0ConOtrosValores() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(3000, 5500, 0, 7500, 6000));
		assertEquals(1480, calculadoraCompleja.calcula(listaVenta));
	}
	//condicion de borde 5000, solo deberia tomar la comision fija del 5%
	@Test
	public void condicionDeBorde5000() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(5000, 5000, 5000, 5000, 5000));
		assertEquals(1250, calculadoraCompleja.calcula(listaVenta));
	}
	
	//deberia tomar la comision de 8% pero no tomar la comision sobre 50000
	@Test
	public void condicionDeBorde10000() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(10000, 10000, 10000, 10000, 10000));
		assertEquals(4000, calculadoraCompleja.calcula(listaVenta));
	}
	
	//deberia ser 9% de comision al superar 50000
	@Test
	public void condicionDeBorde10000sobre50000() {
		List<Integer> listaVenta = new ArrayList<>(Arrays.asList(10001, 10000, 10000, 10000, 10000));
		assertEquals(4500, calculadoraCompleja.calcula(listaVenta));
	}

}
