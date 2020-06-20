package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 8:34 上午
 */
public interface BlogService extends IService<Blog> {
    /**
     * 获取博客详情
     *
     * @param id 博客id
     * @return 返回博客对象
     */
    Blog getDetail(Integer id);
}
