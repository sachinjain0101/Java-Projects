package com.sacsoft;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

	protected static Integer counter = 5;
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" - START");

		Integer finalSum = 0;
		List<RandomSum> lstRandSum = new ArrayList<RandomSum>();	
		while(counter>0){
			counter--;
			RandomSum rs = new RandomSum();
			Thread thread = new Thread(rs);
			thread.start();
			thread.join();
			lstRandSum.add(rs);
		}

		for(RandomSum rs:lstRandSum){
			finalSum = finalSum+rs.getRndInt();
		}

		System.out.println(Thread.currentThread().getName()+" Grand Total - "+finalSum);
		System.out.println(Thread.currentThread().getName()+" - END");

	}

}
