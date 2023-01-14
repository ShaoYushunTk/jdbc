package src.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo_Connection {
    public static void main(String[] args) throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // sql
        String sql1 = "UPDATE account SET money = 4000 WHERE id = 1";
        String sql2 = "UPDATE account SET money = 5000 WHERE id = 2";


        // 获取执行sql的对象
        Statement stmt = conn.createStatement();

        // 事务管理中出现异常则回滚
        try {
            // 开启事务
            conn.setAutoCommit(false);

            //执行sql
            int count1 = stmt.executeUpdate(sql1); //受影响的行数

            //打印结果
            System.out.println(count1);

            // 异常语句
            //int i = 3/0;

            //执行sql
            int count2 = stmt.executeUpdate(sql2); //受影响的行数

            //打印结果
            System.out.println(count2);

            // 提交事务
            conn.commit();

        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }




        //释放
        stmt.close();
        conn.close();

    }
}
