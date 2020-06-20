package cn.scorpiodong.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客表(Blog)实体类
 *
 * @author makejava
 * @since 2020-06-15 08:27:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {
    private static final long serialVersionUID = 706687999355799650L;
    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 分类id
     */
    private Integer sortId;
    /**
    * 题目
    */
    private String title;
    /**
    * 描述
    */
    private String description;
    /**
    * 内容
    */
    @TableField(select = false)
    private String content;
    /**
    * 封面图
    */
    private String cover;
    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 更新时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 分类对象
     */
    @TableField(exist = false)
    private Sort sort;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", cover='" + cover + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sort=" + sort +
                '}';
    }
}