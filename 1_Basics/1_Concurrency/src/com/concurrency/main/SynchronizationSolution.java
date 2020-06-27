package com.concurrency.main;
/*
 * 
 * Thread OverHead
 * 
 * */

public class SynchronizationSolution {

	public static int counter = 0;
	
	/*
	 * 
	 * synchronized keyword makes sure if each of the two threads has finished their job by communicating each other 
	 * 
	 * */
	public static synchronized void increment() {
		counter++;
	}


	public static void process1() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					increment();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					increment();
				}

			}
		});

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}


	public static void main(String[] args) {

		process1();

		System.out.println(counter);


	}
	
}