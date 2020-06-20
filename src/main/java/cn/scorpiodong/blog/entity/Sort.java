package cn.scorpiodong.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分类表(Sort)实体类
 *
 * @author makejava
 * @since 2020-06-15 08:23:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sort implements Serializable {
    private static final long serialVersionUID = -34500551127492968L;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(exist = false)
    private List<Blog> blogs;

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