package cn.scorpiodong.blog.controller;

import cn.scorpiodong.blog.util.JsonResult;
import cn.scorpiodong.blog.util.token.TokenRequired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/15 4:44 下午
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping("/upload")
    @TokenRequired
    public JsonResult upload(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return JsonResult.DEFAULT_ERROR.msg("文件不能为空");
            }
            String fileName = file.getOriginalFilename();
            String suffixName = null;
            if (fileName == null) {
                return JsonResult.DEFAULT_ERROR.msg("文件名不能为空");
            }
            suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID() + suffixName;
            String filePath = System.getProperty("user.dir") + "/.blog/assets/upload/";
            File dest = new File(filePath + fileName);
            file.transferTo(dest);
            return JsonResult.of("/assets/upload/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonResult.DEFAULT_ERROR;
    }
}
