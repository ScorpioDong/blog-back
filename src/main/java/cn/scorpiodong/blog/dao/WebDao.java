package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Web;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/30 9:03 下午
 */
@Repository
public class WebDao extends BaseMemoryDao<Web> {
    @Override
    public Web select(Integer id) {
        Web web = super.select(id);
        Web obj = new Web();
        BeanUtils.copyProperties(web, obj);
        return obj;
    }
}
