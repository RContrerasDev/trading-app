package com.roboto.operations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		
		List<Double> ratesLst = new ArrayList<Double>();
		ratesLst.add(10.20);
		ratesLst.add(15.20);
		ratesLst.add(12.65);
		ratesLst.add(11.48);
		ratesLst.add(13.80);
		ratesLst.add(14.32);
		
		Double maximum = ratesLst.stream().max(Comparator.comparing(e -> e)).get();
		
		Double max = ratesLst.stream().max(Comparator.comparing(Double::valueOf)).get();
		Double min = ratesLst.stream().min(Comparator.comparing(Double::valueOf)).get();
		
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		Double maxSupRange = max + .5 * max / 100;
		Double maxInfRange = max - .5 * max / 100;
		System.out.println("Rango maximo superior: " + maxSupRange);
		System.out.println("Rango maximo inferior: " + maxInfRange);
		
		// Rango mínimo superior
		Double minSupRange = min + .5 * min / 100;
		// Rango mínimo inferior
		Double minInfRange = min - .5 * min / 100;
		
		System.out.println("Rango mínimo superior: " + minSupRange);
		System.out.println("Rango mínimo inferior: " + minInfRange);
		
		// EMAt = a * precio actual + (1- a) * EMAt-1
		// a = .22
		// precio actual = 186
		// 1-a = .78
		// EMAt-1 = 172.625
		Double a = .222222;
		Double precioActual = 186.00;
		Double a1 = .78;
		Double emat1 =  172.625;
		Double ema = a * precioActual + (1-a) * emat1;
		System.out.println("EMA: " + ema);

	}

}
