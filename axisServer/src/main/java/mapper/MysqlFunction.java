package main.java.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jingwen
 * @Description MySQL执行函数
 * @DATE 2021/10/30 19:31
 */
public class MysqlFunction {

    public static SqlSession getSqlSession(){
        InputStream io= null;
        try {
            io = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(io);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }
}
