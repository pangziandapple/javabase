package apple.pangzi.lock.lockcondiction;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description :
 */
public class Test {

    public static void main(String[] args) {
        Task task = new Task();
        for(int i = 0;i<4;i++){
            AddRunnable addRunnable = new AddRunnable();
            addRunnable.setTask(task);
            addRunnable.setThreadName("thread" + i);
            new Thread(addRunnable).start();
        }

//        for(int i = 0;i<10;i++){
//            SubRunnable subRunnable = new SubRunnable();
//            subRunnable.setTask(task);
//            subRunnable.setThreadName("subThread" + i);
//            new Thread(subRunnable).start();
//        }
    }
}
