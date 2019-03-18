package apple.pangzi.jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangzhiheng
 * @Date 2019-03-05
 * @Description :
 */
public class MyDataSource {

   private String userName;

   private String passWd;

   private String url;

   private Long initSize;

   private Long maxPoolSize;

   private List<ConnectionHolder> connectionHolders;

   private ReentrantLock reentrantLock = new ReentrantLock();

   public MyDataSource(){

   }

   public Connection getConnection(){
       return null;
   }

    public List<ConnectionHolder> getConnectionHolders() {
        return connectionHolders;
    }

    public void setConnectionHolders(List<ConnectionHolder> connectionHolders) {
        this.connectionHolders = connectionHolders;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getInitSize() {
        return initSize;
    }

    public void setInitSize(Long initSize) {
        this.initSize = initSize;
    }

    public Long getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Long maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
}
