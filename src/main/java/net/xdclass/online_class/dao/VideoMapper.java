package net.xdclass.online_class.dao;

import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
}
