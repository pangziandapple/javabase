package apple.pangzi.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description : 锁的基本用法
 */
public class ReentrantLockTest {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        LockThread tread1 = new LockThread();
        tread1.setReentrantLockTest(reentrantLockTest);
        tread1.setThreadName("thread1");

        LockThread tread2 = new LockThread();
        tread2.setReentrantLockTest(reentrantLockTest);
        tread2.setThreadName("thread2");

        new Thread(tread1).start();
        new Thread(tread2).start();
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }
}
