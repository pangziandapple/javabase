package apple.pangzi.lock.lockcondiction;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description :
 */
public class AddRunnable implements Runnable {

    private Task task;

    private String threadName;

    @Override
    public void run() {
        try {
            task.setThreadName(threadName);
            task.addList();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
