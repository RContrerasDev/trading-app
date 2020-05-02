package com.roboto.operations;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class BBands {
	
	public static Double calcVarianza(List<Double> ratesLst, Double median) {
		Double varianza = 0.00;
		// Generar diferencias
		List<Double> diferencias = ratesLst.stream()
				.mapToDouble(e -> e - median)
				.boxed()
				.collect(Collectors.toList());
		// Elevar las diferencias al cuadrado
		List<Double> cuadrados = diferencias.stream()
				.mapToDouble(e -> Math.pow(e, 2))
				.boxed()
				.collect(Collectors.toList());
		// Suma de las diferencias
		Double difSum = cuadrados.stream().mapToDouble(Double::doubleValue).sum();
		Integer difSumSize = cuadrados.size();
		// Calcular varianza
		varianza = difSum / difSumSize;

		return varianza;
	}
	
public static BollingerBands getPreviousBollBands(List<Double> list) {
		
		BollingerBands bollingerBands = new BollingerBands();
		
		List<Double> subList = list.subList(Math.max(list.size() - 7, 0), list.size() - 1);
		//Calcula la media o promedio
		Integer lstSize = subList.size();
		Double sum = subList.stream().mapToDouble(Double::doubleValue).sum();
		// media
		Double median = sum / lstSize;
		// Varianza
		Double varianza = calcVarianza(subList, median);
		// Desviacion
		Double desviacion = Math.sqrt(varianza);
		// Banda superior
		Double bandaSuperior = median + (desviacion * 2);
		bollingerBands.setBandaSuperior(bandaSuperior);
		// Banda inferior
		Double bandaInferior = median - (desviacion * 2);
		bollingerBands.setBandaInferior(bandaInferior);
		
		return bollingerBands;
	}

	public static void main(String[] args) {

		// Bandas de Bollinger
		List<Double> ratesLst = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 
				1.084675, 1.084645, 1.08464, 1.08345, 1.084011, 1.084124, 1.086118, 1.085587, 1.086095);
		
		List<Double> ratesLst1 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645);
		BollingerBands bb1 = getPreviousBollBands(ratesLst1);		
		System.out.println(ratesLst1.get(ratesLst1.size() - 1) + " BB SUp: " + bb1.getBandaSuperior() + " BB Inf: " + bb1.getBandaInferior());
		
		List<Double> ratesLst2 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645, 1.08464);
		BollingerBands bb2 = getPreviousBollBands(ratesLst2);		
		System.out.println(ratesLst2.get(ratesLst2.size() - 1) + " BB SUp: " + bb2.getBandaSuperior() + " BB Inf: " + bb2.getBandaInferior());
		
		List<Double> ratesLst3 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645, 1.08464, 1.08345);
		BollingerBands bb3 = getPreviousBollBands(ratesLst3);		
		System.out.println(ratesLst3.get(ratesLst3.size() - 1) + " BB SUp: " + bb3.getBandaSuperior() + " BB Inf: " + bb3.getBandaInferior());
		
		List<Double> ratesLst4 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645, 1.08464, 1.08345, 1.084011);
		BollingerBands bb4 = getPreviousBollBands(ratesLst4);		
		System.out.println(ratesLst4.get(ratesLst4.size() - 1) + " BB SUp: " + bb4.getBandaSuperior() + " BB Inf: " + bb4.getBandaInferior());
		
		List<Double> ratesLst5 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645, 1.08464, 1.08345, 1.084011, 1.084124);
		BollingerBands bb5 = getPreviousBollBands(ratesLst5);		
		System.out.println(ratesLst5.get(ratesLst5.size() - 1) + " BB SUp: " + bb5.getBandaSuperior() + " BB Inf: " + bb5.getBandaInferior());
		
		List<Double> ratesLst6 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645, 1.08464, 1.08345, 1.084011, 1.084124, 1.086118);
		BollingerBands bb6 = getPreviousBollBands(ratesLst6);		
		System.out.println(ratesLst6.get(ratesLst6.size() - 1) + " BB SUp: " + bb6.getBandaSuperior() + " BB Inf: " + bb6.getBandaInferior());
		
		List<Double> ratesLst7 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645, 1.08464, 1.08345, 1.084011, 1.084124, 1.086118, 1.085587);
		BollingerBands bb7 = getPreviousBollBands(ratesLst7);		
		System.out.println(ratesLst7.get(ratesLst7.size() - 1) + " BB SUp: " + bb7.getBandaSuperior() + " BB Inf: " + bb7.getBandaInferior());
		
		List<Double> ratesLst8 = Arrays.asList(1.083178, 1.083488, 1.084223, 1.084131, 1.084381, 1.084675, 1.084645, 1.08464, 1.08345, 1.084011, 1.084124, 1.086118, 1.085587, 1.086095);
		BollingerBands bb8 = getPreviousBollBands(ratesLst8);		
		System.out.println(ratesLst8.get(ratesLst8.size() - 1) + " BB SUp: " + bb8.getBandaSuperior() + " BB Inf: " + bb8.getBandaInferior());

	}

}
