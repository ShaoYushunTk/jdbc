package src.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class jdbcDemo_Statement {
    /**
     * 执行DML语句
     * @throws Exception
     */
    @Test
    public void testDML() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // sql
        String sql = "UPDATE account SET money = 3000 WHERE id = 1";

        //获取执行sql的对象
        Statement stmt = conn.createStatement();

        //执行sql
        int count = stmt.executeUpdate(sql); //执行完DML语句后受影响的行数

        //
        //System.out.println(count);
        if (count > 0) {
            System.out.println("修改成功");
        }
        else {
            System.out.println("修改失败");
        }

        //释放
        stmt.close();
        conn.close();
    }

    /**
     * 执行DDL语句
     * @throws Exception
     */
    @Test
    public void testDDL() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // sql
        String sql = "drop database db2";

        //获取执行sql的对象
        Statement stmt = conn.createStatement();

        //执行sql
        int count = stmt.executeUpdate(sql); //执行完语句后受影响的行数

        //
        System.out.println(count);


        //释放
        stmt.close();
        conn.close();
    }

}
