package com.roboto.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Actions {

	public void nuevaOpcion() throws AWTException {

		Robot robot = new Robot();
		// Ir a la posición del botón Nueva Opción
		robot.mouseMove(1853, 421);
		// Hacer clik y release
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		// Posicionar el mouse al centro de la pantalla
		robot.mouseMove(932, 328);

	}

	public void abrirOpcionSUBE() throws AWTException {

		Robot robot = new Robot();
		// Ir a la posición del botón Sube
		robot.mouseMove(1860, 462);
		// Hacer clik y release
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		// Posicionar el mouse al centro de la pantalla
		robot.mouseMove(932, 328);
	}

	public void abrirOpcionBAJA() throws AWTException {

		Robot robot = new Robot();
		// Ir a la posición del botón Baja
		robot.mouseMove(1857, 562);
		// Hacer clik y release
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		// Posicionar el mouse al centro de la pantalla
		robot.mouseMove(932, 328);
	}

}
