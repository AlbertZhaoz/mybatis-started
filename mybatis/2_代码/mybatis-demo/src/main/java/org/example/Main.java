package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName:${NAME}
 * Package:org.example
 * Description:
 *
 * @Author AlbertZhao
 * @Create 3/2/2024 5:19 PM
 * @Version 1.0
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        // 1.加载 mybatis 核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取 SqlSession 对象，用它来执行 sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行 sql
        // 名称空间+id
        List<User> users = sqlSession.selectList("UserMapper.selectAllUser");

        // 4.输出结果
        System.out.println(users);

        // 5.关闭资源
        sqlSession.close();
    }
}