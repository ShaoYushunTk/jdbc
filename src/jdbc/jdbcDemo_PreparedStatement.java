package src.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * PreparedStatement 预编译SQL语句 防止SQL注入，将敏感字符进行转义
 */
public class jdbcDemo_PreparedStatement {
    /**
     * PreparedStatement
     * @throws Exception
     */
    @Test
    public void testPreparedStatement() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // 接收输入
        String name = "zhangsan";
        //String pwd = "123";
        String pwd = "' or '1' = '1";

        // sql 问号作为占位符 设置传入参数
        String sql = "select * from user where username = ? and password = ?";

        // pstmt
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置？的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        // 执行sql
        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        //释放
        resultSet.close();
        pstmt.close();
        conn.close();

    }


    /**
     * PreparedStatement 原理
     * @throws Exception
     */
    @Test
    public void testPreparedStatement2() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        // useServerPrepStmts=true 打开预编译功能
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useServerPrepStmts=true";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // 接收输入
        String name = "zhangsan";
        //String pwd = "123";
        String pwd = "' or '1' = '1";

        // sql 问号作为占位符 设置传入参数
        String sql = "select * from user where username = ? and password = ?";

        // pstmt
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置？的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        // 执行sql
        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        //释放
        resultSet.close();
        pstmt.close();
        conn.close();

    }
}
