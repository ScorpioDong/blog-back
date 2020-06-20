package cn.scorpiodong.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 网站信息表(Web)实体类
 *
 * @author makejava
 * @since 2020-06-14 10:11:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Web implements Serializable {
    private static final long serialVersionUID = 641154332862925734L;
    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 网站名
     */
    private String webName;
    /**
     * 域名
     */
    private String domain;
    /**
     * avatar
     */
    private String avatar;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 座右铭
     */
    private String motto;
    /**
     * cover
     */
    private String cover;

    @Override
    public String toString() {
        return "Web{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", webName='" + webName + '\'' +
                ", domain='" + domain + '\'' +
                ", avatar='" + avatar + '\'' +
                ", keywords='" + keywords + '\'' +
                ", motto='" + motto + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}