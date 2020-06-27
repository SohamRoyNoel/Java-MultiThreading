package com.concurrency.main;

/*
 * 
 * By using join we can wait for the other threads to finish execution 
 * 
 * */

public class ThreadJoins2 {

	public static void main(String[] args) {
		
		Runner5 r5 = new Runner5();
		Runner6 r6 = new Runner6();
		
		r5.start();
		r6.start();
		
		try {
			r5.join();
			r6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.err.println("Download Finished");

	}

}
/*
Runner1 : 0
Runner1 : 1
Runner1 : 2
Runner1 : 3
Runner1 : 4
Runner1 : 5
Runner1 : 6
Runner1 : 7
Runner1 : 8
Runner1 : 9
Runner2 : 0
Runner2 : 1
Runner2 : 2
Runner2 : 3
Runner2 : 4
Runner2 : 5
Runner2 : 6
Runner2 : 7
Runner2 : 8
Runner2 : 9
Download Finished
*/