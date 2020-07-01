package cn.scorpiodong.blog.service.impl;

import cn.scorpiodong.blog.dao.BlogDao;
import cn.scorpiodong.blog.dao.SortDao;
import cn.scorpiodong.blog.entity.Page;
import cn.scorpiodong.blog.entity.Sort;
import cn.scorpiodong.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:17 下午
 */
@Service
public class SortServiceImpl implements SortService {
    private SortDao sortDao;
    private BlogDao blogDao;

    @Override
    public List<Sort> all() {
        return sortDao.selectAll();
    }

    @Override
    public Sort one(Integer id) {
        Sort sort = sortDao.select(id);
        sort.setBlogs(blogDao.selectBySortId(id));
        return sort;
    }

    @Override
    public boolean save(Sort sort) {
        return sortDao.insert(sort);
    }

    @Override
    public boolean update(Sort sort) {
        return sortDao.update(sort) != null;
    }

    @Override
    public boolean remove(Integer id) {
        return sortDao.delete(id) != null;
    }

    @Override
    public Page<Sort> page(Page<Sort> page) {
        return sortDao.selectPage(page);
    }


    @Autowired
    public void setSortDao(SortDao sortDao) {
        this.sortDao = sortDao;
    }

    @Autowired
    public void setBlogDao(BlogDao blogDao) {
        this.blogDao = blogDao;
    }
}
