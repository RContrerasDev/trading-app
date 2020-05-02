package com.roboto.main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.roboto.actions.ActionPUT;
import com.roboto.actions.ActionSELL;
import com.roboto.domain.BollingerBands;
import com.roboto.handler.Handler;
import com.roboto.utils.MathOperations;

public class BbEma {

	public static void main(String[] args) {
		
		System.out.println("Start application at " + Calendar.getInstance().getTime());
		Date startDate = Date.from(LocalDateTime.of(2020, 4, 10, 19, 33).atZone(ZoneId.systemDefault()).toInstant());
		List<Double> ratesLst = new ArrayList<Double>();
		Timer timer = new Timer();
		ActionPUT put = new ActionPUT();
		ActionSELL sell = new ActionSELL();
		
		TimerTask task = new TimerTask() {
			Handler handler = new Handler();

			@Override
			public void run() {
				
				// Get rate
				Double rate = handler.getUSDRate();
				// Add rate to the rates list
				ratesLst.add(rate);
				// If the rates list has 6 or more elements, get Bollinger Bands
				if (ratesLst.size() >= 6) {
					BollingerBands bb = MathOperations.getBollBands(ratesLst);
					
					System.out.println(rate + " " 
					+ Calendar.getInstance().getTimeInMillis() 
					+ " BB Superior: " + bb.getBandaSuperior() 
					+ " BB Inferior: " + bb.getBandaInferior());
					// Identify lateral market - pending
					
					// If the rate gets out of the bands
					if(rate > bb.getBandaSuperior()) {
						System.out.println("SELL");
						sell.run();
					}else if(rate < bb.getBandaInferior()) {
						System.out.println("PUT");
						put.run();
					}
					
				}
				
			}
			
		};
		
		/*La tarea se ejecuta cada 60 segundos, 
		 * iniciando a la hora y fecha señaladas.*/
		timer.schedule(
				task, 
				startDate, 
				60000);


	}

}
