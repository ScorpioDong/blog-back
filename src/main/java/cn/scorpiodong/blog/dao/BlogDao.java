package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Blog;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:41 下午
 */
@Repository
public class BlogDao extends BaseMemoryDao<Blog> {

    @Override
    public Blog select(Integer id) {
        Blog blog = super.select(id);
        Blog obj = new Blog();
        BeanUtils.copyProperties(blog, obj, Blog.class);
        obj.setContent(readToString(System.getProperty("user.dir") + blog.getContentPath()));
        return obj;
    }

    @Override
    public boolean insert(Blog blog) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName = blog.getTitle() + "-" + format.format(blog.getCreateTime()) + ".md";
            String filePath = "/.blog/data/markdown/";
            File dest = new File(System.getProperty("user.dir") + filePath + fileName);
            Writer writer = new BufferedWriter(new FileWriter(dest));
            writer.write(blog.getContent());
            writer.flush();
            writer.close();

            blog.setContentPath(filePath + fileName);
            blog.setContent(null);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return super.insert(blog);
    }

    @Override
    public Blog update(Blog blog) {
        try {
            File dest = new File(System.getProperty("user.dir") + blog.getContentPath());
            Writer writer = new BufferedWriter(new FileWriter(dest));
            writer.write(blog.getContent());
            writer.flush();
            writer.close();

            blog.setContent(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return super.update(blog);
    }

    public List<Blog> selectBySortId(Integer id) {
        List<Blog> blogs = new ArrayList<>();
        for (Blog blog : this.list) {
            if (blog.getSortId().equals(id)) {
                blogs.add(blog);
            }
        }
        return blogs;
    }

    private String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        long fileLength = file.length();
        byte[] fileContent = new byte[(int) fileLength];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
            return new String(fileContent, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
