package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Web;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/30 9:00 下午
 */
public interface WebService {
    Web login(String username, String password);

    Web info();

    boolean update(Web web);
}
