package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Sort;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 8:25 上午
 */
public interface SortDao extends BaseMapper<Sort> {
    /**
     * 获取Sort
     *
     * @param id id
     * @return 返回Sort对象
     */
    Sort selectDetail(Integer id);
}
