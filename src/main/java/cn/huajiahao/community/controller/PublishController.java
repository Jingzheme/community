package cn.huajiahao.community.controller;

import cn.huajiahao.community.dto.QuestionDTO;
import cn.huajiahao.community.mapper.QuestionMapper;
import cn.huajiahao.community.model.Question;
import cn.huajiahao.community.model.User;
import cn.huajiahao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Date 2019/7/24 15:05
 * @Created by 11744
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/publish/{id}")
    public  String edit(@PathVariable(name = "id" )Integer id,
                        Model model){
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }
    @GetMapping("/publish")
    public String publish(){
        return"publish";
    }
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam ("tag") String tag,
            @RequestParam("id")Integer id,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

    if (title==null||title==""){
        model.addAttribute("error","标题不能为空");
        return "publsih";
    }

    if (description==null||description==""){
        model.addAttribute("error","问题补充不能为空");
        return  "publish";
    }

    if(tag==null||tag==""){
        model.addAttribute("error","标签不能为空");
        return "publish";
    }


        User user = (User)request.getSession().getAttribute("user");

        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        question.setViewCount(0);
        question.setLikeCount(0);
        question.setCommentCount(0);
        questionService.createOrUpdate(question);
        return "redirect:/";

    }
}
