package cn.huajiahao.community.mapper;

import cn.huajiahao.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Date 2019/7/24 16:51
 * @Created by 11744
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,creator,gmt_create,gmt_modified,tag)values(#{title},#{description},#{creator},#{gmtCreate},#{gmtModified},#{tag})")
    void create(Question question);
}
