package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        blog.setContent(readToString(blog.getContentPath()));
        return blog;
    }

    @Override
    public boolean insert(Blog blog) {
        try {
            String fileName = blog.getTitle() + "-" + UUID.randomUUID() + ".md";
            String filePath = System.getProperty("user.dir") + "/.blog/data/markdown/";
            File dest = new File(filePath + fileName);
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
            File dest = new File(blog.getContentPath());
            Writer writer = new BufferedWriter(new FileWriter(dest));
            writer.write(blog.getContent());
            writer.flush();
            writer.close();

            blog.setContentPath(blog.getContentPath());
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
