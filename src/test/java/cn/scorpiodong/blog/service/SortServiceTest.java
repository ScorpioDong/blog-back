package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Sort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 9:00 上午
 */
@SpringBootTest
class SortServiceTest {

    @Autowired
    SortService sortService;

    @Test
    void getDetail() {
        Sort detail = sortService.getDetail(1);
        System.out.println(detail);
    }
}