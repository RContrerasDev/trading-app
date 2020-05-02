package com.roboto.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.roboto.domain.BollingerBands;
import com.roboto.domain.Stock;

public class MathOperations {
	
	public static boolean isWinLoss(double rate, double lastPrice, String operation) {		
		boolean success = false;
		
		if(operation.equalsIgnoreCase("SUBE")) {
			
			success = rate > lastPrice ? true : false;
			
		} else if (operation.equalsIgnoreCase("BAJA")) {
			
			success = rate < lastPrice ? true : false;			
		}				
		return success;
	}
	
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
	
	public static List<Double> getRange20(List<Double> ratesLst, Integer index) {
		
		List<Double> result = 
				ratesLst.subList(Math.max(ratesLst.size() - index, 0), ratesLst.size());
		
		return result;
	}
	
	public static BollingerBands getBollingerBands(List<Double> list) {
		BollingerBands bollingerBands = new BollingerBands();
		
		//Calcula la media o promedio
		Integer lstSize = list.size();
		Double sum = list.stream().mapToDouble(Double::doubleValue).sum();
		// media
		Double median = sum / lstSize;
		// Varianza
		Double varianza = calcVarianza(list, median);
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
	
	/**
	 * Calculates the Bollinger Bands. This is actually the most accurate.
	 * @param list
	 * @return
	 */
	public static BollingerBands getBollBands(List<Double> list) {
		BollingerBands bollingerBands = new BollingerBands();
		List<Double> subList = list.subList(Math.max(list.size() - 6, 0), list.size());
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
	
	/**
	 * Calculates Bollinger Bands with previous element
	 * @param list
	 * @return
	 */
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
	
	public static BollingerBands getBollingerBandsStock(List<Stock> stockList) {
		
		BollingerBands bollingerBands = new BollingerBands();
		
		// obtener una lista con los precios de cierre.
		List<Double> preciosCierre = 
				stockList.stream()
				.mapToDouble(stock -> stock.getPrecioCierre())
				.boxed()
				.collect(Collectors.toList());		
		
		List<Double> subList = preciosCierre
				.subList(Math.max(preciosCierre.size() - 6, 0), preciosCierre.size());
		
		// Calcula la media o promedio
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
	
	/**
	 * Fórmula utilizada: EMAt = a * precio actual + (1- a) * EMAt-1
	 * @return
	 */
	public Double getEMA(Double factor, Double rate, Double sma) {
		
		/*Double a = .222222;
		Double precioActual = 186.00;
		Double emat1 =  172.625;
		Double ema = a * precioActual + (1-a) * emat1;*/
		// Factor es SMA = 100 periodis / 100 - Pendiente
		Double result = factor * rate + (1-factor) * sma;
		
		return result;
	}
	
	/**
	 * Determina si se detecta un rango para un numero determinado de periodos
	 * @return
	 */
	public boolean isRange(List<Double> rangesLst, Integer periodos) {
		
		// Obtener minimos y maximos a partir de la lista
		
		
		
		
		return false;
		
	}


}
