package com.concurrency.main;
/*
 * Variables are stored in cache assiociated with each CPU; // 776144
 * Using volatile forces java to read the variable from ram : that makes the performance slower // 770401
 * 
 * */

class Games implements Runnable {
	
	private volatile boolean isTerminated = false;
		
	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

	@Override
	public void run() {
		
		int i = 0;
		while(!isTerminated) {
			System.out.println("Hello From Games World : " + i);
			i++;
		}
		
	}
}

public class UsingVolatile {

	public static void main(String[] args) {
		
		Games games = new Games();
		Thread t1 = new Thread(games);
		t1.start();
		
		try {
			t1.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		games.setTerminated(true);
		System.out.println("Good Bye");

	}

}