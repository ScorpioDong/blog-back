package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Blog;
import cn.scorpiodong.blog.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:45 下午
 */
public interface BlogService {
    Blog one(Integer id, boolean isMarkdown);

    Blog last(Integer id);

    Blog next(Integer id);

    Page<Blog> page(Page<Blog> page);

    Map<String, Map<String, List<Blog>>> archives();

    boolean save(Blog blog);

    boolean update(Blog blog);

    boolean remove(Integer id);
}
