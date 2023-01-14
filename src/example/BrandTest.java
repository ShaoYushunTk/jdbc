package src.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import src.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 品牌数据增删改查
 */
public class BrandTest {
    /**
     * 查询所有
     * 1.SQL：select * from brand
     * 2.参数：不需要
     * 3.结果：List<Brand>
     */
    @Test
    public void testSelectAll() throws Exception {

        //1.conn
        // 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Druid.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql = "select * from brand";

        //3.pstmt
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //4.设置参数

        //5.执行sql
        ResultSet resultSet = preparedStatement.executeQuery();

        //6.结果处理
        ArrayList<Brand> list = new ArrayList<>();
        while(resultSet.next()){
            //获取数据
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            //封装对象
            Brand brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            //装载集合
            list.add(brand);

        }

        System.out.println(list);

        //7.资源释放
        resultSet.close();
        preparedStatement.close();
        conn.close();
    }

    /**
     * 添加
     * 1.SQL：insert into brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)
     * 2.参数：除了id
     * 3.结果：boolean
     *
     */
    @Test
    public void testAdd() throws Exception {
        // 接收页面提交参数
        String brandName = "idea";
        String companyName = "idea1";
        int ordered = 1;
        String description = "aaa";
        int status = 1;


        //1.conn
        // 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Druid.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql = "insert into brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)";

        //3.pstmt
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //4.设置参数
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);

        //5.执行sql count为影响行数
        int count = preparedStatement.executeUpdate();

        //6.处理结果
        if (count > 0){
            System.out.println("执行成功");
        }
        else{
            System.out.println("执行失败");
        }


        //7.资源释放
        preparedStatement.close();
        conn.close();
    }

    /**
     * 修改
     * 1.SQL：update brand set brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? where id = ?
     * 2.参数：全部
     * 3.结果：boolean
     *
     */
    @Test
    public void testUpdate() throws Exception {
        // 接收页面提交参数
        String brandName = "tencent";
        String companyName = "tencent";
        int ordered = 1;
        String description = "aaa";
        int status = 1;
        int id = 4;

        //1.conn
        // 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Druid.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql = "update brand set brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? where id = ?";

        //3.pstmt
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //4.设置参数
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        preparedStatement.setInt(6,id);

        //5.执行sql count为影响行数
        int count = preparedStatement.executeUpdate();

        //6.处理结果
        if (count > 0){
            System.out.println("执行成功");
        }
        else{
            System.out.println("执行失败");
        }


        //7.资源释放
        preparedStatement.close();
        conn.close();
    }

    /**
     * 删除
     * 1.SQL：delete from brand where id = ?
     * 2.参数：id
     * 3.结果：boolean
     *
     */
    @Test
    public void testDelete() throws Exception {
        // 接收页面提交参数
        int id = 3;

        //1.conn
        // 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Druid.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql = "delete from brand where id = ?";

        //3.pstmt
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //4.设置参数
        preparedStatement.setInt(1,id);

        //5.执行sql count为影响行数
        int count = preparedStatement.executeUpdate();

        //6.处理结果
        if (count > 0){
            System.out.println("执行成功");
        }
        else{
            System.out.println("执行失败");
        }


        //7.资源释放
        preparedStatement.close();
        conn.close();
    }
}
