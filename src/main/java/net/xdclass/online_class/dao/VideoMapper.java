package net.xdclass.online_class.dao;

import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface VideoMapper {
    /***
     * @author shenhengxin
     * @description 根据视频Id查找视频对象
     * @Date 21:01 2020/9/25
     * @Param [videoId]
     * @return net.xdclass.online_class.domain.Video
     */
    Video selectById(@Param("video_id") int videoId);

    @Select("select * from video")
    List<Video> selectList();


    /***
     * @author shenhengxin
     * @description 根据评分和标题模糊查询
     * @Date 10:55 2020/9/26
     * @Param [point, title]
     * @return net.xdclass.online_class.domain.Video
     */
    List<Video> selectByPointAndTitleLike(@Param("point")double point,@Param("title")String title);

    /**
     * 新增一条视频记录
     * @param video
     * @return
     */
    int add(Video video);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int addBatch(List<Video> list);

    int updateVideo(Video video);

    int updateVideoSelective(Video video);

    int deleteByCreateTimeAndPrice(Map<String,Object> map);

    Video selectBaseFieldByWithResultMap(@Param("video_id") int videoId);
}
