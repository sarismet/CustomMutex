package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class HomeWorkMutex implements Lock {

    ModifiedTestAndSet mylock;

    public HomeWorkMutex () {
        this.mylock = new ModifiedTestAndSet();
    }

    public void requestCS (int threadId) {
        while (this.mylock.isNotFreeToEnterCS(threadId));
        System.out.println("Thread "+threadId+" is in CS : ");
    }

    public void releaseCS (int threadId) {
        this.mylock.testAndSet(0);
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
