package com.roboto.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.TimerTask;

public class ActionSELL2 extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
        Robot robot;
		try {
			robot = new Robot();
			// Colocar posicion BAJA
			// Ir a la posición del botón
			robot.delay(500);
			// Pantalla externa ->	robot.mouseMove(1865, 425);
			// Pantalla laptop
			//IQrobot.mouseMove(1851, 538);
			// Pocket
			robot.mouseMove(546, 967);
			// Hacer clik y release
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
