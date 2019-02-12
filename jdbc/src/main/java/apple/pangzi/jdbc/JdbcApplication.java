package apple.pangzi.jdbc;

import java.sql.*;

/**
 * @author zhangzhiheng
 * @Date 2019-02-12
 */
public class JdbcApplication {

    public static void main(String[] args) throws Exception {
        JdbcApplication jdbcApplication = new JdbcApplication();
        jdbcApplication.queryWithParams();
    }

    /**
     * @Author zhangzhiheng
     * @Description 有参查询
     * @Date  2019/2/12
     * @Param
     * @return
     **/
    public void queryWithParams()throws Exception {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

        String USER = "root";
        String PASS = "root";

        // 注册 JDBC 驱动
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        String sql = "SELECT id, name, age FROM user WHERE name = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,"name1");
        ResultSet rs = stmt.executeQuery();

        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String url = rs.getString("age");

            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 站点名称: " + name);
            System.out.print(", 站点 URL: " + url);
            System.out.print("\n");
        }
        // 完成后关闭
        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     * @Author zhangzhiheng
     * @Description 无参查询
     * @Date  2019/2/12
     * @Param
     * @return
     **/
    public void query()throws Exception {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

        String USER = "root";
        String PASS = "root";

        // 注册 JDBC 驱动
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();


        String sql = "SELECT id, name, age FROM user limit 0,10";
        ResultSet rs = stmt.executeQuery(sql);

        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String url = rs.getString("age");

            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 站点名称: " + name);
            System.out.print(", 站点 URL: " + url);
            System.out.print("\n");
        }
        // 完成后关闭
        rs.close();
        stmt.close();
        conn.close();
    }
}
