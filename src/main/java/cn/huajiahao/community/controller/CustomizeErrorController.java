package cn.huajiahao.community.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.text.normalizer.NormalizerBase;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Date 2019/7/31 16:56
 * @Created by 11744
 */
@Controller()
@RequestMapping("/error")
public class CustomizeErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "error";
    }
    @RequestMapping(produces= MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request,
                                  Model model){
        HttpStatus status =getStatus(request);
        if (status.is4xxClientError()){
            model.addAttribute("message","你这个请求错了，要不然换个姿势？");
        }
        if (status.is5xxServerError()){
            model.addAttribute("message","服务冒烟了，不然哥们你等会儿试试......");
        }
        return new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try{
            return HttpStatus.valueOf(statusCode);
        }catch (Exception ex){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
}


