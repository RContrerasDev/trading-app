package com.roboto.operations;

import java.util.ArrayList;
import java.util.List;

public class Listas {

	public static void main(String[] args) {
		
		List<Double> ratesLst = new ArrayList<Double>();
		ratesLst.add(18.2);
		ratesLst.add(10.2);
		ratesLst.add(12.2);
		ratesLst.add(13.2);
		ratesLst.add(14.2);
		
		ratesLst.remove(0);
		//List<Double> subLst = ratesLst.subList(0, 2);
		ratesLst.forEach(System.out::println);
		
		
/*		ratesLst = ratesLst.subList(ratesLst.size() - 4, ratesLst.size());
		ratesLst.forEach(System.out::println);*/

	}

}
