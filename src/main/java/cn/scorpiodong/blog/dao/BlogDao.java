package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.Blog;
import cn.scorpiodong.blog.util.ListUtils;
import cn.scorpiodong.blog.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:41 下午
 */
@Repository
public class BlogDao extends BaseMemoryDao<Blog> {

    private Map<String, Map<String, List<Blog>>> archives;


    public BlogDao() {
        super();
        archives = getArchive(this.list);
    }

    @Override
    public Blog select(Integer id) {
        Blog blog = super.select(id);
        Blog obj = new Blog();
        BeanUtils.copyProperties(blog, obj, Blog.class);
        String markdown = readToString(System.getProperty("user.home") + blog.getContentPath());
        obj.setContent(MarkdownUtils.convert(markdown));
        return obj;
    }

    public Blog selectMarkdown(Integer id) {
        Blog blog = super.select(id);
        Blog obj = new Blog();
        BeanUtils.copyProperties(blog, obj, Blog.class);
        obj.setContent(readToString(System.getProperty("user.home") + blog.getContentPath()));
        return obj;
    }

    public Blog selectPrev(Integer id) {
        int index = this.getIndexById(id);
        if (index == 0 || index == -1) {
            return null;
        }
        Blog blog = this.list.get(index - 1);
        Blog obj = new Blog();
        BeanUtils.copyProperties(blog, obj, Blog.class);
        return obj;
    }

    public Blog selectNext(Integer id) {
        int index = this.getIndexById(id);
        if (index == this.list.size() - 1 || index == -1) {
            return null;
        }
        Blog blog = this.list.get(index + 1);
        Blog obj = new Blog();
        BeanUtils.copyProperties(blog, obj, Blog.class);
        return obj;
    }

    public Map<String, Map<String, List<Blog>>> selectArchives() {
        return this.archives;
    }

    @Override
    public boolean insert(Blog blog) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName = blog.getTitle() + "-" + format.format(blog.getCreateTime()) + ".md";
            String filePath = "/.blog/data/markdown/";
            File dest = new File(System.getProperty("user.home") + filePath + fileName);
            Writer writer = new BufferedWriter(new FileWriter(dest));
            writer.write(blog.getContent());
            writer.flush();
            writer.close();

            blog.setContentPath(filePath + fileName);
            blog.setContent(null);
            archives = getArchive(this.list);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return super.insert(blog);
    }

    @Override
    public Blog update(Blog blog) {
        try {
            File dest = new File(System.getProperty("user.home") + blog.getContentPath());
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

    private Map<String, Map<String, List<Blog>>> getArchive(List<Blog> list) {
        Map<String, Map<String, List<Blog>>> map = new HashMap<>();
        List<Blog> blogs = ListUtils.deepCopy(list);
        if (blogs != null) {
            blogs.sort(Comparator.comparing(Blog::getCreateTime));
        }

        if (blogs != null) {
            for (Blog blog : blogs) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(blog.getCreateTime());
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                Map<String, List<Blog>> mapYear = map.computeIfAbsent(year + "", k -> new HashMap<>());
                List<Blog> mapMonth = mapYear.computeIfAbsent(month + "", k -> new ArrayList<>());
                Blog obj = new Blog();
                obj.setId(blog.getId());
                obj.setTitle(blog.getTitle());
                obj.setCreateTime(blog.getCreateTime());
                mapMonth.add(obj);
            }
        }
        return map;
    }
}
