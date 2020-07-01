package cn.scorpiodong.blog.controller;

import cn.scorpiodong.blog.entity.Page;
import cn.scorpiodong.blog.entity.Sort;
import cn.scorpiodong.blog.service.SortService;
import cn.scorpiodong.blog.util.JsonResult;
import cn.scorpiodong.blog.util.token.TokenRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 9:28 上午
 */
@CrossOrigin
@RestController
@RequestMapping("/sort")
public class SortController {
    private SortService sortService;

    @GetMapping("/all")
    public JsonResult getAll() {
        List<Sort> list = sortService.all();
        return JsonResult.of(list);
    }

    @GetMapping("/{id}")
    public JsonResult getOne(@PathVariable Integer id) {
        Sort detail = sortService.one(id);
        return JsonResult.of(detail);
    }

    @GetMapping("/{current}/{size}")
    public JsonResult getPage(@PathVariable Integer current, @PathVariable Integer size) {
        Page<Sort> page = sortService.page(new Page<>(current, size));
        return JsonResult.of(page);
    }

    @PostMapping("/add")
    @TokenRequired
    public JsonResult add(@RequestBody Sort sort) {
        boolean result = sortService.save(sort);
        if (result) {
            return JsonResult.SUCCESS;
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @PutMapping("/update")
    @TokenRequired
    public JsonResult update(@RequestBody Sort sort) {
        boolean result = sortService.update(sort);
        if (result) {
            return JsonResult.SUCCESS;
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @DeleteMapping("/{id}")
    @TokenRequired
    public JsonResult delete(@PathVariable Integer id) {
        boolean result = sortService.remove(id);
        if (result) {
            return JsonResult.SUCCESS;
        }
        return JsonResult.DEFAULT_ERROR;
    }

    @Autowired
    public void setSortService(SortService sortService) {
        this.sortService = sortService;
    }
}
