package com.concurrency.main;
/*
 * 
 * Thread Join : waits for the other thread to be completed before finishing MAIN thread;
 * Ex: if thread1 is downloading image from web and thread 2 is facebook; its worthless to show "Download Complete" even before images are downloaded from source 
 * 
 * */
class Runner5 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.err.println("Runner1 : " + i);
		}		
	}
	
}

class Runner6 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner2 : " + i);
		}		
	}
	
}
public class ThreadJoins {

	public static void main(String[] args) {
		
		Runner5 r5 = new Runner5();
		Runner6 r6 = new Runner6();
		
		r5.start();
		r6.start();
		
		System.err.println("Download Finished");

	}

}
/*
Download Finished
Runner1 : 0
Runner1 : 1
Runner1 : 2Runner2 : 0
Runner2 : 1
Runner2 : 2
Runner2 : 3
Runner2 : 4
Runner2 : 5
Runner2 : 6
Runner2 : 7
Runner2 : 8
Runner2 : 9

Runner1 : 3
Runner1 : 4
Runner1 : 5
Runner1 : 6
Runner1 : 7
Runner1 : 8
Runner1 : 9
*/