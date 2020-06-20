package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Web;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/14 4:10 下午
 */
@SpringBootTest
class WebServiceTest {

    @Autowired
    WebService webService;

    @Test
    void login() {
        Web admin = webService.login("admin", "971101");
        System.out.println(admin);
    }
}