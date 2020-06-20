package cn.scorpiodong.blog.service;

import cn.scorpiodong.blog.entity.Web;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/14 10:15 上午
 */
public interface WebService extends IService<Web> {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回一个网站信息
     */
    Web login(String username, String password);
}
