package com.company;

public class Mythread extends Thread {
    HomeWorkMutex myMutex;
    int id;
    public Mythread (int id,HomeWorkMutex myMutex){
        this.id = id;
        this.myMutex = myMutex;
    }

    public void run() {
        int index = 0;
        while(index < 10){
            System.out.println("Thread id is "+this.id);
            myMutex.requestCS(id);
            System.out.println("isInCS"+this.myMutex.mylock.isInCS+"isCSFree"+this.myMutex.mylock.isCSFree);
            myMutex.releaseCS();
            System.out.println("isInCS"+this.myMutex.mylock.isInCS+"isCSFree"+this.myMutex.mylock.isCSFree);


            index++;
        }
    }
}
