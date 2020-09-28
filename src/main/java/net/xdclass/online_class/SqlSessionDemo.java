package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @ClassName : SqlSessionDemo  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-25 20:59  //时间
 */
public class SqlSessionDemo {
    public static void main(String[] args) throws IOException {
        String resouce = "config/mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resouce);
        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取Session
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
            Video video = videoMapper.selectBaseFieldByWithResultMap(44);
            System.out.println(video.toString());

           // List<Video> videoList = videoMapper.selectList();
            //System.out.println(videoList.toString());

            //多参数查询
            //List<Video> videoList = videoMapper.selectByPointAndTitleLike(8.7, "HTML");
            //System.out.println(videoList.toString());

            //新增一条记录
           /* Video video1 = new Video();
            video1.setTitle("小滴课堂面试专题300道");
            video1.setCoverImg("xdclass.net/aaa.png");
            video1.setPoint(9.4);
            video1.setCreateTime(new Date());
            video1.setPrice(9900);
            video1.setSummary("面试专题概要");*/
            //final int rows = videoMapper.add(video1);
            //System.out.println(rows);
          /*  Video video2 = new Video();
            video2.setTitle("小滴课堂面试专题200道");
            video2.setCoverImg("xdclass.net/aaa.png");
            video2.setPoint(9.2);
            video2.setCreateTime(new Date());
            video2.setPrice(9200);
            video2.setSummary("面试专题概要");
            List<Video> list = new ArrayList<>();*/
            //list.add(video1);
            //list.add(video2);
            /*list.addAll(Arrays.asList(video1,video2));
            final int rows = videoMapper.addBatch(list);
            System.out.println(rows);*/

            //Video video = new Video();
            //video.setId(46);
            //video.setTitle("新版javase零基础到高级教程小白自学编程");
           // video.setCoverImg("https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/video/javase/javase.png");
           // video.setPoint(8.80);
           // video.setCreateTime(new Date());
            //video.setPrice(3980);
            //video.setSummary("https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/video/javase/javase_detail.png");
           // videoMapper.updateVideo(video);
            //videoMapper.updateVideoSelective(video);

            /*Map<String,Object> map = new HashMap<>();
            map.put("createTime","2021-01-11 09:33:20");
            map.put("price",9000);

            final int rows = videoMapper.deleteByCreateTimeAndPrice(map);
            System.out.println(rows);*/
        }
    }
}
