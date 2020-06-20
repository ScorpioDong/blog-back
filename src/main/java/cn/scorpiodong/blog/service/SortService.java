package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Sort;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 8:33 上午
 */
public interface SortService extends IService<Sort> {
    /**
     * 获取Sort详情
     *
     * @param id id
     * @return 返回Sort对象
     */
    Sort getDetail(Integer id);
}
