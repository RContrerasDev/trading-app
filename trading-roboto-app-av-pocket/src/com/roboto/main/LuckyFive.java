package com.roboto.main;

import static com.roboto.utils.IConstants.BAJA;
import static com.roboto.utils.IConstants.SUBE;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.roboto.actions.ActionPUT2;
import com.roboto.actions.ActionPutLucky;
import com.roboto.actions.ActionSELL2;
import com.roboto.domain.BollingerBands;
import com.roboto.handler.Handler;
import com.roboto.utils.MathOperations;

public class LuckyFive {
	
	static boolean inAction = false;
	static Double lastPrice = 0.00;
	static Integer loses = 0;
	static Integer wins = 0;
	static String operation = "";
	static Integer waitPeriods = 0;

	public static void main(String[] args) {
		
		System.out.println("Start application at " + Calendar.getInstance().getTime());
		Date startDate = Date.from(LocalDateTime
				.of(2020, 4, 26, 10, 23)
				.atZone(ZoneId.systemDefault())
				.toInstant());
		
		Timer timer = new Timer();
		ActionPutLucky put = new ActionPutLucky();
		
		TimerTask task = new TimerTask() {
			Handler handler = new Handler();

			@Override
			public void run() {
				
				// Get rate
				Double rate = handler.getUSDRate();
				System.out.println(rate + " " + Calendar.getInstance().getTime());
				
				// Calculate if win or loss
				if(inAction == true) {						
					if(MathOperations.isWinLoss(rate, lastPrice, operation)) {
						wins ++;
						System.out.println("Wins: " + wins);
					} else {
						loses ++;
						System.out.println("Loses: " + loses);
					}
					operation = "";
					lastPrice = 0.00;
					inAction = false;
				}
				
				put.run();
				
			}
			
		};
		
		/*La tarea se ejecuta cada minuto, 
		 * iniciando a la hora y fecha señaladas.*/
		timer.schedule(
				task, 
				startDate, 
				60000);

	}

}
