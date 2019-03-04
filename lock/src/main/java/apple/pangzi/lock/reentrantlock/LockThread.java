package apple.pangzi.lock.reentrantlock;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description :
 */
public class LockThread implements Runnable {

    private ReentrantLockTest reentrantLockTest;

    private String threadName;

    @Override
    public void run() {
        try {
            tryLockWithTime(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tryLockWithTime(int time) throws InterruptedException {
        boolean success = reentrantLockTest.getLock().tryLock(time, TimeUnit.SECONDS);
        if(success){
            System.out.println(threadName + "获取到锁！");
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + threadName);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                reentrantLockTest.getLock().unlock();
            }

        }else {
            System.out.println(threadName + "获取线程失败！");
        }
    }

    private void tryLock() {
        boolean success = reentrantLockTest.getLock().tryLock();
        if(success){
            System.out.println(threadName + "获取到锁！");
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + threadName);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                reentrantLockTest.getLock().unlock();
            }

        }else {
            System.out.println(threadName + "获取线程失败！");
        }
    }

    private void commonLock() {
        reentrantLockTest.getLock().lock();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + threadName);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            reentrantLockTest.getLock().unlock();
        }
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public ReentrantLockTest getReentrantLockTest() {
        return reentrantLockTest;
    }

    public void setReentrantLockTest(ReentrantLockTest reentrantLockTest) {
        this.reentrantLockTest = reentrantLockTest;
    }
}
