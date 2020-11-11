package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class HomeWorkMutex implements Lock {

    ModifiedSwap mylock;

    public HomeWorkMutex (ModifiedSwap mylock) {
        this.mylock = mylock;
    }

    public void requestCS (int threadId) {
        while (this.mylock.isNotFreeToEnterCS(1,0,threadId));
        System.out.println("Thread "+threadId+" is in CS : ");
    }

    public void releaseCS () {
        this.mylock.swap(0,1);
    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
