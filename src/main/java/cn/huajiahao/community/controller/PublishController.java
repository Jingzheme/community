package cn.huajiahao.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description TODO
 * @Date 2019/7/24 15:05
 * @Created by 11744
 */
@Controller
public class PublishController {
   @GetMapping("/publish")
    public String publish(){
        return"publish";
    }
}
