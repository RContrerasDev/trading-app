package com.roboto.main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.roboto.actions.ActionPUT2;
import com.roboto.actions.ActionPutDouble;
import com.roboto.actions.ActionSELL2;
import com.roboto.actions.ActionSellDouble;
import com.roboto.domain.BollingerBands;
import com.roboto.handler.Handler;
import com.roboto.utils.MathOperations;

import static com.roboto.utils.IConstants.SUBE;
import static com.roboto.utils.IConstants.BAJA;

public class Bollinger {
	
	static boolean inAction = false;
	static Double lastPrice = 0.00;
	static Integer loses = 0;
	static Integer wins = 0;
	static String operation = "";
	static Integer waitPeriods = 0;
	static boolean doubleOrder = false;

	public static void main(String[] args) {
		
		System.out.println("Start application at " + Calendar.getInstance().getTime());
		Date startDate = Date.from(LocalDateTime
				.of(2020, 4, 30, 21, 30)
				.atZone(ZoneId.systemDefault())
				.toInstant());
		List<Double> ratesLst = new ArrayList<Double>();
		Double rango = 0.00015;
		
		Timer timer = new Timer();
		ActionPUT2 put2 = new ActionPUT2();
		ActionSELL2 sell2 = new ActionSELL2();
		ActionSellDouble sellDouble = new ActionSellDouble();
		ActionPutDouble putDouble = new ActionPutDouble();
		
		TimerTask task = new TimerTask() {
			Handler handler = new Handler();

			@Override
			public void run() {
				
				// Get rate
				Double rate = handler.getUSDRate();
				//System.out.println(rate + " " + Calendar.getInstance().getTime());
				// Add rate to the rates list
				ratesLst.add(rate);
				
				// If waitPeriods has been set, start discounting
				if(waitPeriods > 0 ) {
					// Keep calculating Bollinger Bands and printing
					// Bring BB Bands from previous period
					BollingerBands bb = MathOperations.getPreviousBollBands(ratesLst);					
					// Print quotes and BB Bands values
					System.out.println(rate + " " + bb.getBandaSuperior() + " " + bb.getBandaInferior());
					waitPeriods --;
				}
				
				// When loses = 2, will set waitPeriods to 2 and loses = 0.
				if(loses == 2) {
					// Set periods to skip
					waitPeriods = 2;
					// Reset loses counter
					loses = 0;
				}
				
				// If i lose more than two times
				if(loses < 2 && waitPeriods == 0) {
					
					// If the rates list has 7 or more elements, get Bollinger Bands
					if (ratesLst.size() >= 7) {
						
						// Calculate if win or loss
						if(inAction == true) {						
							if(MathOperations.isWinLoss(rate, lastPrice, operation)) {
								wins ++;
								System.out.println("Wins: " + wins);
							} else {
								loses ++;
								doubleOrder = true;
								System.out.println("Loses: " + loses);
							}
							operation = "";
							lastPrice = 0.00;
							inAction = false;
						}
						
						// Bring BB Bands from previous period
						BollingerBands bb = MathOperations.getPreviousBollBands(ratesLst);
						// Print quotes and BB Bands values
						System.out.println(rate + " " + bb.getBandaSuperior() + " " + bb.getBandaInferior());
						
						// If the rate gets out of the bands
						if(rate > bb.getBandaSuperior() + rango) 
						{
							System.out.println(BAJA);
							if(doubleOrder == true) {
								sellDouble.run();
								doubleOrder = false;
							} else {
								sell2.run();
							}							
							lastPrice = rate;
							operation = BAJA;
							inAction = true;
						}
						else if(rate < bb.getBandaInferior() - rango) 
						{
							if(doubleOrder == true) {
								putDouble.run();
								doubleOrder = false;
							} else {
								put2.run();
							}
							System.out.println(SUBE);
							lastPrice = rate;
							operation = SUBE;
							inAction = true;
						}
						
					}
				} else {
					System.out.println("You lost two times already. "
							+ "Wait " + waitPeriods + " periods to restart.");
				}
				
				// When wins > loses, cancel the task. Means success
				if(wins > loses) {
					cancel();
					System.out.println("Succesful session ended at " + Calendar.getInstance().getTime());
				}
			}
			
		};
		
		/*La tarea se ejecuta cada 30 minutos, 
		 * iniciando a la hora y fecha señaladas.*/
		timer.schedule(
				task, 
				startDate, 
				1800000);

	}

}
