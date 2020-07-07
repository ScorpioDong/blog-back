package cn.scorpiodong.blog.controller;

import cn.scorpiodong.blog.entity.Blog;
import cn.scorpiodong.blog.entity.Page;
import cn.scorpiodong.blog.service.BlogService;
import cn.scorpiodong.blog.util.JsonResult;
import cn.scorpiodong.blog.util.token.TokenRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/one/{id}/{markdown}")
    public JsonResult getOne(@PathVariable Integer id, @PathVariable boolean markdown) {
        Blog detail = blogService.one(id, markdown);
        return JsonResult.of(detail);
    }

    @GetMapping("/near/{id}")
    public JsonResult getNear(@PathVariable Integer id) {
        Blog last = blogService.last(id);
        Blog next = blogService.next(id);
        Map<String, Blog> map = new HashMap<>();
        if (last != null) {
            map.put("last", last);
        } else if (next != null) {
            map.put("next", next);
        }
        return JsonResult.of(map);
    }

    @GetMapping("/page/{current}/{size}")
    public JsonResult getPage(@PathVariable Integer current, @PathVariable Integer size) {
        Page<Blog> page = blogService.page(new Page<>(current, size));
        return JsonResult.of(page);
    }

    @GetMapping("/archives")
    public JsonResult getArchives() {
        Map<String, Map<String, List<Blog>>> archives = blogService.archives();
        return JsonResult.of(archives);
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
        boolean result = blogService.update(blog);
        if (result) {
            return JsonResult.SUCCESS;
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @DeleteMapping("/{id}")
    @TokenRequired
    public JsonResult delete(@PathVariable Integer id) {
        boolean result = blogService.remove(id);
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
