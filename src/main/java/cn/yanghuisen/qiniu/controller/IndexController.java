package cn.yanghuisen.qiniu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 12:13
 * @Description TODO
 */
@Controller
public class IndexController {

    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }
}
