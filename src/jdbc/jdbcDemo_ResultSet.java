package src.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo_ResultSet {
    /**
     * 执行DQL语句
     * @throws Exception
     */
    @Test
    public void testResultSet() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        // sql
        String sql = "select * from account";

        //获取执行sql的对象stmt
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet resultSet = stmt.executeQuery(sql);

        //处理结果
        //光标向下移动一行，判断当前行是否有效，有效返回true
        while (resultSet.next()){
            //获取数据
            int id = resultSet.getInt(1);
            int money = resultSet.getInt(2);//int money = resultSet.getInt("money");


            System.out.println(id);
            System.out.println(money);
            System.out.println();
        }

        //释放
        resultSet.close();
        stmt.close();
        conn.close();

    }
}
