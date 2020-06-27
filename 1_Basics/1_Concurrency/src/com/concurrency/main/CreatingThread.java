package com.concurrency.main;

/*
 * 
 * Multithreading if CPU has more then 1 core
 * 
 * */
class Runner3 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.err.println("Runner1 : " + i);
		}		
	}
	
}

class Runner4 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner2 : " + i);
		}		
	}
	
}

public class CreatingThread {

	public static void main(String[] args) {

		Runner3 r3 = new Runner3();
		Runner4 r4 = new Runner4();
		
		r3.start();
		r4.start();
		

	}

}
/*
 * 
 *
 *Time Slicing : if there is only 1 core available: it catches the core1 then core 2 then core 1 this is called time slicing 
 * 
 * */
 