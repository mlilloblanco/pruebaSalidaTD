package org.mlb.pruebaSalidaTD.comisiones;

import java.util.List;

public class CalculadoraSimple implements CalculadoraComisiones {

	private int totalVenta;

	public CalculadoraSimple() {
		super();
	}

	@Override
	public int calcula(List<Integer> listaVentas) {
		totalVenta = 0;

		for (Integer venta : listaVentas) {
			totalVenta += venta;
		}

		if (totalVenta > 10000) {
			return (int) (totalVenta * 0.1f);
		} else {
			return (int) (totalVenta * 0.05f);
		}

	}

}
