package src.jdbc;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo_UserLogin {
    /**
     * 用户登录
     * @throws Exception
     */
    @Test
    public void testLogin() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // 接收输入
        String name = "zhangsan";
        String pwd = "123";

        // sql
        String sql = "select * from user where username = '"+name+"' and password = '"+pwd+"'";

        // 获取stmt对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        //释放
        resultSet.close();
        stmt.close();
        conn.close();

    }

    /**
     * SQL注入
     * @throws Exception
     */
    @Test
    public void testLogin_Inject() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // 接收输入
        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        // sql
        String sql = "select * from user where username = '"+name+"' and password = '"+pwd+"'";

        // 获取stmt对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        //释放
        resultSet.close();
        stmt.close();
        conn.close();

    }
}
