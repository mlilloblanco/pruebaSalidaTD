package org.mlb.pruebaSalidaTD.comisiones;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
		System.out.println("Tomando 5 montos  de venta aleatorios...");
		List<Integer> listaVenta = generarAleatorios();
		System.out.println(listaVenta.toString());
		
		CalculadoraSimple calculadoraSimple = new CalculadoraSimple();
		System.out.println("Comision con Algoritmo Simple: " + calculadoraSimple.calcula(listaVenta));
		CalculadoraCompleja calculadoraCompleja = new CalculadoraCompleja();
		System.out.println("Comision con Algoritmo Complejo: " + calculadoraCompleja.calcula(listaVenta));
		
	}
	
	public static List<Integer> generarAleatorios() {
	int max = 20000;
	int min = 1000;
	List<Integer> listaVenta = new ArrayList<>();
	for (int i = 0; i < 5; i++) {
		int EnteroAleatorio = (int)(Math.random() * (max - min + 1) + min);
		listaVenta.add(EnteroAleatorio);
	}
	return listaVenta;	

	}

}
