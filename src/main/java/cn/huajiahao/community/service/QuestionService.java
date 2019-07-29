package cn.huajiahao.community.service;

import cn.huajiahao.community.dto.PaginationDTO;
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
    
    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = questionMapper.count();
        if(totalCount%size==0){
            totalPage =  totalCount/size;
        }else{
            totalPage = totalCount/size+1;
        }

        if(page<1){
            page=1;
        }
        if (page>totalPage){
            page =totalPage;
        }
        paginationDTO.setPagination(totalPage,page);
        //size*(page -1)
        Integer offset = size*(page-1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();


        for (Question question:questions){
            User user  = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = questionMapper.countByUserId(userId);
        if(totalCount%size==0){
            totalPage =  totalCount/size;
        }else{
            totalPage = totalCount/size+1;
        }

        if(page<1){
            page=1;
        }
        if (page>totalPage){
            page =totalPage;
        }
        paginationDTO.setPagination(totalPage,page);

        //size*(page -1)
        Integer offset = size*(page-1);
        List<Question> questions = questionMapper.listByUserId(userId,offset,size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();


        for (Question question:questions){
            User user  = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }
}
