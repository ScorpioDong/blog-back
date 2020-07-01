package cn.scorpiodong.blog.dao;


import cn.scorpiodong.blog.entity.Sort;
import org.junit.jupiter.api.Test;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/30 8:22 下午
 */
class BaseMemoryDaoTest {
    @Test
    public void init() {
        BaseMemoryDao<Sort> dao = new BaseMemoryDao<Sort>();
        dao.save();
    }

    @Test
    public void add() {
        BaseMemoryDao<Sort> dao = new BaseMemoryDao<Sort>();
        Sort sort = new Sort();
        sort.setName("测试");
        sort.setDescription("测试描述");
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.insert(sort);
        dao.save();
    }

    @Test
    public void printString() {
        BaseMemoryDao<Sort> dao = new BaseMemoryDao<>();
        System.out.println(dao);
    }
}