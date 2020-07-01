package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Sort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:57 下午
 */
@SpringBootTest
class SortDaoTest {
    @Autowired
    SortDao sortDao;

    @Test
    public void add() {
        Sort sort1 = new Sort();
        sort1.setName("杂项");
        sort1.setDescription("未分类");
        sortDao.insert(sort1);
        Sort sort2 = new Sort();
        sort2.setName("Java");
        sort2.setDescription("Java学习笔记");
        sortDao.insert(sort2);
        Sort sort3 = new Sort();
        sort3.setName("MySQL");
        sort3.setDescription("MySQL学习笔记");
        sortDao.insert(sort3);
        Sort sort4 = new Sort();
        sort4.setName("杂记");
        sort4.setDescription("记录生活");
        sortDao.insert(sort4);
        Sort sort5 = new Sort();
        sort5.setName("SSM");
        sort5.setDescription("Spring、SpringMVC、MyBatis 框架学习笔记");
        sortDao.insert(sort5);


        sortDao.save();
    }
}