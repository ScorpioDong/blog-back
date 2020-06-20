package cn.scorpiodong.blog.service.impl;

import cn.scorpiodong.blog.dao.SortDao;
import cn.scorpiodong.blog.entity.Sort;
import cn.scorpiodong.blog.service.SortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 8:34 上午
 */
@Service
public class SortServiceImpl extends ServiceImpl<SortDao, Sort> implements SortService {
    @Override
    public Sort getDetail(Integer id) {
        return baseMapper.selectDetail(id);
    }
}
