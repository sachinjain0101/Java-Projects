package com.sacsoft;

import java.util.Random;

public class RandomSum implements Runnable {

	protected Integer rndInt;

	public Integer getRndInt() {
		return rndInt;
	}

	public void setRndInt(Integer rndInt) {
		this.rndInt = rndInt;
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		Random rand = new Random();
		Integer i = rand.nextInt(10);
		System.out.println(threadName + " : " + i);
		setRndInt(i);
	}

}
