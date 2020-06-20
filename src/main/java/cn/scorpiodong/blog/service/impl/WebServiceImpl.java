package cn.scorpiodong.blog.service.impl;

import cn.scorpiodong.blog.dao.WebDao;
import cn.scorpiodong.blog.entity.Web;
import cn.scorpiodong.blog.service.WebService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/14 10:17 上午
 */
@Service
public class WebServiceImpl extends ServiceImpl<WebDao, Web> implements WebService {
    @Override
    public Web login(String username, String password) {
        QueryWrapper<Web> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<Web> webs = baseMapper.selectList(wrapper);
        if (webs.size() != 0) {
            Web web = webs.get(0);
            if (web != null) {
                if (password.equals(web.getPassword())) {
                    return web;
                }
            }
        }
        return null;
    }
}
