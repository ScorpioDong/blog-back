package cn.scorpiodong.blog.controller;

import cn.scorpiodong.blog.entity.Blog;
import cn.scorpiodong.blog.service.BlogService;
import cn.scorpiodong.blog.util.JsonResult;
import cn.scorpiodong.blog.util.token.TokenRequired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 3:35 下午
 */
@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogController {
    private BlogService blogService;

    @GetMapping("/{id}")
    public JsonResult getOne(@PathVariable Integer id) {
        Blog detail = blogService.getDetail(id);
        return JsonResult.of(detail);
    }

    @GetMapping("/{current}/{size}")
    public JsonResult getPage(@PathVariable Integer current, @PathVariable Integer size) {
        Page<Blog> page = blogService.page(new Page<>(current, size));
        return JsonResult.of(page);
    }

    @PostMapping("/add")
    @TokenRequired
    public JsonResult add(@RequestBody Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        boolean result = blogService.save(blog);
        if (result) {
            return JsonResult.SUCCESS;
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @PutMapping("/update")
    @TokenRequired
    public JsonResult update(@RequestBody Blog blog) {
        blog.setUpdateTime(new Date());
        boolean result = blogService.saveOrUpdate(blog);
        if (result) {
            return JsonResult.SUCCESS;
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @DeleteMapping("/{id}")
    @TokenRequired
    public JsonResult delete(@PathVariable String id) {
        boolean result = blogService.removeById(id);
        if (result) {
            return JsonResult.SUCCESS;
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }
}
