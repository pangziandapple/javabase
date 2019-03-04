package apple.pangzi.lock.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description :  读写线程锁，可以同时读没问题。不能够同时读写必须其中一个等待另外一个锁释放才可以进行进行
 */
public class ReadWriteLock {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        ReadRunable readRunable = new ReadRunable();
        readRunable.setReadWriteLock(readWriteLock);
        readRunable.setThreadName("读线程1");

        ReadRunable readRunable2 = new ReadRunable();
        readRunable2.setReadWriteLock(readWriteLock);
        readRunable2.setThreadName("读线程2");

        WriteRunable writeRunable = new WriteRunable();
        writeRunable.setReadWriteLock(readWriteLock);
        writeRunable.setThreadName("写线程1");

        new Thread(readRunable).start();
        new Thread(readRunable2).start();
        new Thread(writeRunable).start();

    }

    public ReentrantReadWriteLock getReentrantReadWriteLock() {
        return reentrantReadWriteLock;
    }

    public void setReentrantReadWriteLock(ReentrantReadWriteLock reentrantReadWriteLock) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
    }
}
