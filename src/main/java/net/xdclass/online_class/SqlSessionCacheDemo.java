package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.dao.VideoOrderMapper;
import net.xdclass.online_class.domain.User;
import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName : SqlSessionDemo  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-25 20:59  //时间
 */
public class SqlSessionCacheDemo {
    public static void main(String[] args) throws IOException {
        String resouce = "config/mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resouce);
        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取Session
        try {
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            final VideoMapper videoMapper1 = sqlSession1.getMapper(VideoMapper.class);
            final Video video1 = videoMapper1.selectById(44);
            System.out.println(video1);
            sqlSession1.commit();

            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            final VideoMapper videoMapper2 = sqlSession2.getMapper(VideoMapper.class);
            final Video video2 = videoMapper2.selectById(44);
            System.out.println(video2);
            sqlSession2.commit();



        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
