package cn.huajiahao.community.controller;

import cn.huajiahao.community.dto.QuestionDTO;
import cn.huajiahao.community.mapper.QuestionMapper;
import cn.huajiahao.community.mapper.UserMapper;
import cn.huajiahao.community.model.Question;
import cn.huajiahao.community.model.User;
import cn.huajiahao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/7/19 16:07
 * @Created by 11744
 */

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies != null&&cookies.length != 0){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        List<QuestionDTO> questionDTOList = questionService.list();
        model.addAttribute("questions",questionDTOList);
        return "index";
    }
}
