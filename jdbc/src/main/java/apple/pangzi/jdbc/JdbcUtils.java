package apple.pangzi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zhangzhiheng
 * @Date 2019-02-12
 */
public class JdbcUtils {

    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

    private static String USER = "root";

    private static String PASS = "root";


    public static Connection getConnection(String dirver, String dbUrl, String userName, String passwd) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

}
