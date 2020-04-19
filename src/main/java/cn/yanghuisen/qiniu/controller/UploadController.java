package cn.yanghuisen.qiniu.controller;

import cn.yanghuisen.qiniu.model.ResultInfo;
import cn.yanghuisen.qiniu.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 12:31
 * @Description TODO
 */

@Controller
public class UploadController {

    @Resource
    private UploadService uploadService;
    @RequestMapping("upload")
    @ResponseBody
    public ResultInfo upload(MultipartFile file) throws IOException {
        // 调用service层的上传文件方法
        ResultInfo info = new ResultInfo();
        info.setData(uploadService.upload(file));
        return info;
    }
}
