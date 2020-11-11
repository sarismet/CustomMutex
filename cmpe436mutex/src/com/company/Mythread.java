package com.company;

public class Mythread extends Thread {
    static HomeWorkMutex myMutex = new HomeWorkMutex();
    int id;
    public Mythread (int id){
        this.id = id;
    }

    public void run() {
        int index = 0;
        while(index < 10){

            myMutex.requestCS(id);
            System.out.println("value : "+myMutex.mylock.myValue+" - "+" turn : "+myMutex.mylock.turn);
            myMutex.releaseCS(id);


            index++;
        }
    }
}
