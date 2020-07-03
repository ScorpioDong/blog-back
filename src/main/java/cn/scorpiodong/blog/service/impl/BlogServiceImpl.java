package cn.scorpiodong.blog.service.impl;

import cn.scorpiodong.blog.dao.BlogDao;
import cn.scorpiodong.blog.dao.SortDao;
import cn.scorpiodong.blog.entity.Blog;
import cn.scorpiodong.blog.entity.Page;
import cn.scorpiodong.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:46 下午
 */
@Service
public class BlogServiceImpl implements BlogService {
    private BlogDao blogDao;
    private SortDao sortDao;

    @Override
    public Blog one(Integer id, boolean isMarkdown) {
        Blog blog;
        if (!isMarkdown) {
            blog = blogDao.select(id);
        } else {
            blog = blogDao.selectMarkdown(id);
        }
        blog.setSort(sortDao.select(blog.getSortId()));
        return blog;
    }

    @Override
    public Page<Blog> page(Page<Blog> page) {
        return blogDao.selectPage(page);
    }

    @Override
    public boolean save(Blog blog) {
        return blogDao.insert(blog);
    }

    @Override
    public boolean update(Blog blog) {
        return blogDao.update(blog) != null;
    }

    @Override
    public boolean remove(Integer id) {
        return blogDao.delete(id) != null;
    }

    @Autowired
    public void setBlogDao(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Autowired
    public void setSortDao(SortDao sortDao) {
        this.sortDao = sortDao;
    }
}
