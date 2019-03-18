package apple.pangzi.lock.lockcondiction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description :
 */
public class Task {

    private ReentrantLock lock = new ReentrantLock();

    private Condition addCondition = lock.newCondition();

    private Condition subCondition = lock.newCondition();

    private List<Integer> nums = new ArrayList<Integer>();

    private static Integer startNum = 0;

    private String threadName;

    public void addList() throws InterruptedException {
        lock.lock();
        try {
            if(nums.size() == 10){
                addCondition.await();
            }

            System.out.println(threadName + "开始添加数据" + startNum);
            nums.add(startNum);
            startNum ++;
            subCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void subList() throws InterruptedException {
        lock.lock();
        try {
            if(nums.size() == 0){
                subCondition.wait();
            }

            Integer val = nums.get(0);
            nums.remove(0);
            startNum--;
            System.out.println(threadName + "删除数据" + val);
            addCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
