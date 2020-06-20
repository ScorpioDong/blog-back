package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 8:32 上午
 */
public interface BlogDao extends BaseMapper<Blog> {
    /**
     * 获取博客详情
     *
     * @param id 博客id
     * @return 返回博客详情对象
     */
    Blog selectDetail(Integer id);
}
