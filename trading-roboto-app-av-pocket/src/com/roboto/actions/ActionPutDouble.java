package com.roboto.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.TimerTask;

public class ActionPutDouble extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
        Robot robot;
		try {
			robot = new Robot();
			// Doblar cantidad
			robot.delay(250);
			robot.mouseMove(873, 985);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			// Colocar posicion SUBE
			// Ir a la posici�n del bot�n
			robot.delay(500);
			// Pantalla externa -> robot.mouseMove(1865, 425);
			// Pantalla laptop
			//IQ - robot.mouseMove(1858, 421);
			// Pocket
			robot.mouseMove(1129, 964);
			// Hacer clik y release
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			// Reducir la cantidad
			robot.delay(500);
			robot.mouseMove(805, 985);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
