package com.roboto.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ActionPUT extends TimerTask {

	@Override
	public synchronized void run() {
		
		
		Robot robot;
		try {
			robot = new Robot();
			// Cambiar el tiempo de expiracion.
/*			robot.mouseMove(1880, 161);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/
			Timer timer = new Timer();
			ActionNewOption newOption = new ActionNewOption();
			timer.schedule(newOption, 40000);
			//System.out.println("PUT " + Calendar.getInstance().getTimeInMillis());
			// Ir a la posición del botón Sube
			// Pantalla externa -> 
			//robot.mouseMove(1860, 462);
			// Pantalla laptop -> 
			robot.mouseMove(1852, 432);
			// Hacer clik y release
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			// Posicionar el mouse al centro de la pantalla
			// Pantalla externa ->
			//robot.mouseMove(932, 328);
			// Pantalla laptop -> 
			//robot.mouseMove(951, 462);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
