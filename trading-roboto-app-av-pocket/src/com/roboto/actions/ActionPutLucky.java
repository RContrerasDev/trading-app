package com.roboto.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class ActionPutLucky extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
        Robot robot;
		try {
			robot = new Robot();
			Timer timer = new Timer();
			ActionNewOption newOption = new ActionNewOption();
			timer.schedule(newOption, 40000);
			// Colocar posicion SUBE
			// Ir a la posición del botón
			robot.delay(500);
			// Pantalla externa -> robot.mouseMove(1865, 425);
			// Pantalla laptop
			robot.mouseMove(1858, 421);
			// Hacer clik y release
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
