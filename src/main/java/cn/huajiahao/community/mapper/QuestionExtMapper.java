package cn.huajiahao.community.mapper;

import cn.huajiahao.community.model.Question;


public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}