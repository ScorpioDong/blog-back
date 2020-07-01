package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Web;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:57 下午
 */
@SpringBootTest
class WebDaoTest {
    @Autowired
    WebDao webDao;

    @Test
    public void add() {
        Web web = new Web();
        web.setId(1);
        web.setUsername("admin");
        web.setPassword("971101");
        web.setNickname("ScorpioDong");
        web.setWebName("ScorpioDong的个人小站");
        web.setKeywords("ScorpioDong, ScorpioDong的个人小站, 学习交流, 博客, blog");
        web.setDomain("http://www.scorpiodong.cn");
        web.setAvatar("/assets/img/pika.jpeg");
        web.setCover("/assets/img/cover/cover9.jpg");
        webDao.insert(web);
        webDao.save();
    }
}