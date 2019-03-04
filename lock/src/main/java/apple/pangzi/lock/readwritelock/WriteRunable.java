package apple.pangzi.lock.readwritelock;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description :
 */
public class WriteRunable implements Runnable{

    private ReadWriteLock readWriteLock;

    private String threadName;

    @Override
    public void run() {
        readWriteLock.getReentrantReadWriteLock().writeLock().lock();
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
            readWriteLock.getReentrantReadWriteLock().writeLock().unlock();
        }
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    public void setReadWriteLock(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }
}
