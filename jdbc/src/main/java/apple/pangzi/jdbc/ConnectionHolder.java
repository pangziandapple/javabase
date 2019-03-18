package apple.pangzi.jdbc;

import java.sql.Connection;

/**
 * @author zhangzhiheng
 * @Date 2019-03-05
 * @Description :
 */
public class ConnectionHolder {

    private Connection connection;

    private boolean valid;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
