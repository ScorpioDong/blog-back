package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Page;
import cn.scorpiodong.blog.entity.Sort;

import java.util.List;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:17 下午
 */
public interface SortService {
    List<Sort> all();

    Sort one(Integer id);

    boolean save(Sort sort);

    boolean update(Sort sort);

    boolean remove(Integer id);

    Page<Sort> page(Page<Sort> page);
}
