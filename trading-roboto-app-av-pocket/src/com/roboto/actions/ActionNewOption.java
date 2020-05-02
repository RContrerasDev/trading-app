package com.roboto.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Calendar;
import java.util.TimerTask;

public class ActionNewOption extends TimerTask {

	@Override
	public void run() {
		
		Robot robot;
		try {
			robot = new Robot();
			// Ir a la posición del botón Nueva Opción
			// Pantalla externa -> 
			//robot.mouseMove(1853, 421);
			// Pantalla laptop -> 
			robot.mouseMove(1854, 430);
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
