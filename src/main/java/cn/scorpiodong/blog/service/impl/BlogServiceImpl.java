package cn.scorpiodong.blog.service.impl;

import cn.scorpiodong.blog.dao.BlogDao;
import cn.scorpiodong.blog.entity.Blog;
import cn.scorpiodong.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 8:35 上午
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogDao, Blog> implements BlogService {
    @Override
    public Blog getDetail(Integer id) {
        return baseMapper.selectDetail(id);
    }
}
