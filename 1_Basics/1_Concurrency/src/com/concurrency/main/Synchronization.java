package com.concurrency.main;
/*
 * 
 * While 2 threads try to access a same variable its possible that
 * t1 is incrementing value value of counter=counter+1 = 1
 * so t2 is getting the value of counter=counter+1 = 2  
 * 
 * */

public class Synchronization {

	public static int counter = 0;


	public static void process1() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					counter++;
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					counter++;
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
