package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class HomeWorkMutex implements Lock {

    ModifiedTestAndSet mylock;

    public HomeWorkMutex (ModifiedTestAndSet mylock) {
        this.mylock = mylock;
    }

    public void requestCS (int threadId) {
        //System.out.println("Requesting");
        int i = 0;
        while (this.mylock.isNotFreeToEnterCS(threadId)){

            //System.out.println("Thread "+threadId+"is in bussing waiting Turn is "+mylock.turn + "myvlue is "+mylock.myValue);
        }
        System.out.println("Thread "+threadId+" is in CS : ");
    }

    public void releaseCS () {

        this.mylock.testAndSet(0);
        //System.out.println("Releasing Turn is "+mylock.turn + "myvlue is "+mylock.myValue);
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
