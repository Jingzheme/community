package cn.huajiahao.community.service;

import cn.huajiahao.community.dto.QuestionDTO;
import cn.huajiahao.community.mapper.QuestionMapper;
import cn.huajiahao.community.mapper.UserMapper;
import cn.huajiahao.community.model.Question;
import cn.huajiahao.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/7/25 14:59
 * @Created by 11744
 */
@Service
public class QuestionService {
    
    @Autowired
    private QuestionMapper questionMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question:questions){
            User user  = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
