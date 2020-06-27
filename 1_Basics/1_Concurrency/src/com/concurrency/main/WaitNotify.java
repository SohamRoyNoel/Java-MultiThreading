package com.concurrency.main;

/*
 * 
 * Locking same class by 2 Threads
 * 
 * */

class Processor {

	public void producer() throws InterruptedException {

		// this refers to the class itself
		synchronized (this) {
			System.err.println("Produce Method invoked");
			wait(); // Lock
			System.out.println("Again Producer");
		}

	}

	public void consumer() throws InterruptedException {

		/*
		 * Removing sleep will lead us to DEADLOCK position
		 * */
		Thread.sleep(1000); 

		synchronized (this) {
			System.out.println("Consumer Method Invoked");
			notify(); // Notify notifies all LOCKED THread that it can wake up : 
			/*
			 * Notify is non deterministic : that means it will never Guarantee which locked thread to wake up. 
			 * 
			 * */
		}

	}

}


public class WaitNotify {

	public static void main(String[] args) {

		Processor processor = new Processor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					processor.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					processor.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
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
		
		System.out.println("Done....");
		

	}

}
