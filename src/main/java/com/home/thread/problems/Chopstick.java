package com.home.thread.problems;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    private int id;
    private Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }


    /* This method will decide whether philosopher is able
     *to pick up given chopstick or not
     */
    public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {

        if(lock.tryLock(10, TimeUnit.MILLISECONDS)){
            System.out.println(philosopher + " was able to pick up " + state + " chopstick " + this);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher,State state) throws InterruptedException {
            lock.unlock();
            System.out.println(philosopher + " put down  " + state + " chopstick "+ this);
    }

    @Override
    public String toString() {
        return "Chopstick{" +
                "id=" + id +
                '}';
    }
}
