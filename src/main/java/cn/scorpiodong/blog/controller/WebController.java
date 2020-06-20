package cn.scorpiodong.blog.controller;

import cn.scorpiodong.blog.entity.Web;
import cn.scorpiodong.blog.service.WebService;
import cn.scorpiodong.blog.util.JsonResult;
import cn.scorpiodong.blog.util.token.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/14 4:16 下午
 */
@CrossOrigin
@RestController
@RequestMapping("/web")
public class WebController {
    private WebService webService;

    @PostMapping("/login")
    public JsonResult login(@RequestBody Web user) {
        Web login = webService.login(
                user.getUsername(),
                user.getPassword()
        );
        if (login != null) {
            String token = TokenUtils.token(
                    login.getUsername(),
                    login.getPassword()
            );
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", token);
            return JsonResult.of(map);
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @GetMapping("/info")
    public JsonResult getWeb() {
        Web web = webService.list().get(0);
        web.setUsername(null);
        web.setPassword(null);
        return JsonResult.of(web);
    }

    @Autowired
    public void setWebService(WebService webService) {
        this.webService = webService;
    }
}
