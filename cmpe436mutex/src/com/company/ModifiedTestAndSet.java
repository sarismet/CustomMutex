package com.company;

public class ModifiedTestAndSet {
    int myValue = -1; // lock
    // atomic function below
    int turn = -1;
    public synchronized int testAndSet(int newValue) {
        int oldValue = myValue;
        myValue = newValue;
        return oldValue;
    }

    public synchronized boolean isNotFreeToEnterCS(int i) {

        if (turn == -1) {
            testAndSet(1);
            turn = (i + 1)%2;
            return false;
        }
        else if (turn == (i % 2) ){
            if (!(testAndSet(1) == 1)){
                turn = (i + 1) % 2;
                return false;
            }

        }

        return true;
    }
}
