import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.BrandMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.Brand;
import org.example.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName:TestMyBatis
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Author AlbertZhao
 * @Create 3/2/2024 9:56 PM
 * @Version 1.0
 */
public class TestMyBatis {
    @Test
    public void testSelectAllBrand() throws IOException {
        // 1.加载 mybatis 核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取 SqlSession 对象，用它来执行 sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行 sql
        // 名称空间+id
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAllBrand();

        // 4.输出结果
        System.out.println(brands);

        // 5.关闭资源
        sqlSession.close();
    }

    @Test
    public void testSelectOneByName() throws IOException {
        // 1.加载 mybatis 核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取 SqlSession 对象，用它来执行 sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行 sql
        // 名称空间+id
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectOneByName("三只松鼠股份有限公司");

        // 4.输出结果
        System.out.println(brand);

        // 5.关闭资源
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() throws IOException {
        // 1.加载 mybatis 核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取 SqlSession 对象，用它来执行 sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3.执行 sql
        // 名称空间+id
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(1);

        // 5.关闭资源
        sqlSession.close();
    }
}
