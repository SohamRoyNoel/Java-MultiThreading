package com.concurrency.main;

import java.util.concurrent.locks.ReentrantLock;


/*
 * Lock can be used as a replacement of Synchronized  
 * */
public class Lock {

	private static int counter = 0;
	private static ReentrantLock lock = new ReentrantLock();

	public static void increment() {
		/*
		 * Use Unlock in finally; if exception occurs 
		 * the application will be locked forever
		 * */
		
		try {
			lock.lock();
			
			for (int i = 0; i < 10000; i++) {
				counter++;
			}
		}finally {
			lock.unlock();
		}
		
			
	}

	public static void main(String[] args) {

		Thread t12 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Lock1");
				increment();				
			}
		});

		Thread t22 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Lock2");
				increment();				
			}
		});
		
		
		t12.start();
		t22.start();
		
		try {
			t12.join();
			t22.join();
		}catch (InterruptedException e) {
			
		}
		
		System.out.println(counter);
	}
}
