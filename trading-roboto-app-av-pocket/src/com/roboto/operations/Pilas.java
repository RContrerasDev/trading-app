package com.roboto.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pilas {
	
	static List<Double> subLst = new ArrayList<Double>();

	public static void main(String[] args) {
		
		// push - introducir un dato
		// pop - quitar el ultimo dato
		// peek - ver ultimo dato que se introdujo
		// empty - ver si la pila tiene datos
		
		Stack pila = new Stack();
		pila.push(50.25); // indice 0
		pila.push(25.21); // indice 1
		System.out.println(pila.peek());
		System.out.println(pila.get(0));
		
		subLst.add(1.00);
		subLst.clear();
		subLst.add(1.00);
		subLst.forEach(System.out::println);
		
		

	}

}
