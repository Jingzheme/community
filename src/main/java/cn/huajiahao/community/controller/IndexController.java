package cn.huajiahao.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description TODO
 * @Date 2019/7/19 16:07
 * @Created by 11744
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){ return "index"; }
}
