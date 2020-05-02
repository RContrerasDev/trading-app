package com.roboto.response;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class App2 {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		LocalDateTime startLocalDateTime = LocalDateTime.of(2020, 4, 8, 20, 3);
		Clock clock = Clock.system(ZoneId.systemDefault());
		Date startDate = Date.from(startLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				
				System.out.println("Hola Inmundo. Ya es hora! " + Calendar.getInstance().getTime());
				
			}
			
		};
		
		
		timer.schedule(task, startDate, 1000);
		

	}

}
