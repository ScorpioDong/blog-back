package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:57 下午
 */
@SpringBootTest
class BlogDaoTest {
    @Autowired
    BlogDao blogDao;

    @Test
    public void add() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Blog blog1 = new Blog();
        blog1.setSortId(4);
        blog1.setTitle("第一篇博客");
        blog1.setDescription("我自己设计开发的博客网站上线啦，虽然现在只能算是半成品哈。");
        blog1.setContent("# 第一篇博客\n" +
                "\n" +
                "> Author: ScirpioDong\n" +
                "\n" +
                ">  我自己设计开发的博客网站上线啦，虽然现在只能算是半成品哈。\n" +
                "\n" +
                "## 技术栈\n" +
                "\n" +
                "前端： React + antd\n" +
                "\n" +
                "后端： Springboot + MybatisPlus + MySQL\n" +
                "\n" +
                "\n" +
                "\n" +
                "## 后续任务\n" +
                "\n" +
                "继续对前后端进行开发，还有好多地方没有完善呢，一些前端代码写的也是比较冗余，继续优化。\n" +
                "\n" +
                "- 博客目录\n" +
                "- 博客分类页面\n" +
                "- 博客归档页面\n" +
                "- markdown渲染优化\n" +
                "- 适配移动端这个大工程\n" +
                "- 。。。想起来啥写啥\n" +
                "\n" +
                "## 感言\n" +
                "\n" +
                "后端程序员开发前端项目太难啦，但是也算是学习前端了吧。不大的一个项目，后端接口开发了半天，前端的页面和逻辑开发了近五天，主要还是对React不熟悉哈，边学边敲。\n" +
                "\n" +
                "## 项目地址\n" +
                "\n" +
                "[前端项目地址](https://github.com/ScorpioDong/blog-fore)\n" +
                "\n" +
                "[后端项目地址](https://github.com/ScorpioDong/blog-back)");
        blog1.setCover("http://182.61.3.51:8080/api/assets/upload/7ebefdc9-6f7a-4474-b97a-b54e2c76ea42.jpg");
        blog1.setCreateTime(format.parse("2020-06-20 21:16:27"));
        blog1.setUpdateTime(format.parse("2020-06-20 21:23:20"));

        blogDao.insert(blog1);
        Blog blog2 = new Blog();
        blog2.setSortId(4);
        blog2.setTitle("网站更新日志");
        blog2.setDescription("博客网站的更新日志。");
        blog2.setContent("# 更新日志\n" +
                "\n" +
                "> Author: ScorpioDong\n" +
                ">\n" +
                "> 博客网站的更新日志\n" +
                "\n" +
                "### 2020-06-21\n" +
                "> 前端从TypeScript修改为JavaScript（菜鸡程序员使用TypeScript开发不太顺溜).\n" +
                ">\n" +
                "> 优化了前端数据的数据请求和数据存储。\n" +
                ">\n" +
                "> 修改了博客的主题配色。\n" +
                "\n" +
                "### 2020-06-20\n" +
                ">\n" +
                ">网站正式上线。\n");
        blog2.setCover("http://182.61.3.51:8080/api/assets/upload/d0b541cc-1a0b-4fde-8732-c9f1c734f09a.jpg");
        blog2.setCreateTime(format.parse("2020-06-21 09:24:10"));
        blog2.setUpdateTime(format.parse("2020-06-21 22:56:07"));

        blogDao.insert(blog2);
        blogDao.save();

    }
}