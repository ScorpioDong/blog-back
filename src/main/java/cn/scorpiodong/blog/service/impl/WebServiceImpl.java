package cn.scorpiodong.blog.service.impl;


import cn.scorpiodong.blog.dao.WebDao;
import cn.scorpiodong.blog.entity.Web;
import cn.scorpiodong.blog.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/30 9:01 下午
 */
@Service
public class WebServiceImpl implements WebService {
    private WebDao webDao;

    @Override
    public Web login(String username, String password) {
        return webDao.select(0);
    }

    @Override
    public Web info() {
        Web user = webDao.select(0);
        user.setUsername(null);
        user.setPassword(null);
        return user;
    }

    @Autowired
    public void setWebDao(WebDao webDao) {
        this.webDao = webDao;
    }
}
