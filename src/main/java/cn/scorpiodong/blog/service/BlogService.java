package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Blog;
import cn.scorpiodong.blog.entity.Page;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:45 下午
 */
public interface BlogService {
    Blog one(Integer id);

    Page<Blog> page(Page<Blog> page);

    boolean save(Blog blog);

    boolean update(Blog blog);

    boolean remove(Integer id);
}
