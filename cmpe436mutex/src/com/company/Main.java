package com.company;



public class Main {

    public static void main(String[] args) {
	 try{

	     Mythread thread1 = new Mythread(1);
	     Mythread thread2 = new Mythread(2);

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
