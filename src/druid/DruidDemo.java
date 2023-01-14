package src.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid数据库连接池
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception{
        // 导入jar包，定义配置文件

        // 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Druid.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 获取数据库连接
        Connection conn = dataSource.getConnection();
        System.out.println(conn);


    }
}
