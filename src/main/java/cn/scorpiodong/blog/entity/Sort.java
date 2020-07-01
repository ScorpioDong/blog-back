package cn.scorpiodong.blog.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分类表(Sort)实体类
 *
 * @author makejava
 * @since 2020-06-15 08:23:08
 */
public class Sort extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -34500551127492968L;
    /**
     * id
     */
    private Integer id;
    /**
     * 分类名
     */
    private String name;
    /**
     * 分类描述
     */
    private String description;

    /**
     * 博客列表
     */
    private List<Blog> blogs;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}