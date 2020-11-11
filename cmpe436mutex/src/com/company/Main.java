package com.company;

public class Main {

	public static void main(String[] args) {
		try{

			ModifiedTestAndSet mylock = new ModifiedTestAndSet();

			HomeWorkMutex mymutex = new HomeWorkMutex(mylock);

			Mythread thread1 = new Mythread(1,mymutex);
			Mythread thread2 = new Mythread(2,mymutex);

			thread1.start();
			thread2.start();



			thread1.join();
			thread2.join();



		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
