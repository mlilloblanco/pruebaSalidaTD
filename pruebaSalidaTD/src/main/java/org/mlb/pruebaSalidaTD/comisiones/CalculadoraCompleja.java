package org.mlb.pruebaSalidaTD.comisiones;

import java.util.List;

public class CalculadoraCompleja implements CalculadoraComisiones {

	private int totalVenta;

	public CalculadoraCompleja() {
		super();
	}

	@Override
	public int calcula(List<Integer> listaVentas) {
		totalVenta = 0;
		int comision = 0;
		for (Integer venta : listaVentas) {
			totalVenta += venta;
			/*
			 * dado que si existe una venta por 10000 no quedara considerada en ningun rango
			 * dada la definicion opte por incluirla en el 3% de comision
			 */
			if (venta > 5000 && venta < 10000) {
				comision += (int) (venta * 0.07f);
			} else if (venta >= 10000) {
				comision += (int) (venta * 0.08f);
			} else if (venta >=0 && venta <= 5000) {
				comision += (int) (venta * 0.05f);
			}
		}

		if (totalVenta > 50000) {
			comision += totalVenta * 0.01f;
		}

		return comision;
	}

}
