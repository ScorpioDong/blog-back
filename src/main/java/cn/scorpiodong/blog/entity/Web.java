package cn.scorpiodong.blog.entity;

import java.io.Serializable;

/**
 * 网站信息表(Web)实体类
 *
 * @author makejava
 * @since 2020-06-14 10:11:18
 */
public class Web extends BaseEntity implements Serializable {
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
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

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