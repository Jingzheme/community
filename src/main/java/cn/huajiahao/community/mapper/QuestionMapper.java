package cn.huajiahao.community.mapper;

import cn.huajiahao.community.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description TODO
 * @Date 2019/7/24 16:51
 * @Created by 11744
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,creator,gmt_create,gmt_modified,tag)values(#{title},#{description},#{creator},#{gmtCreate},#{gmtModified},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value="offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();
    @Select("select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param(value="userId")Integer userId,@Param(value="offset") Integer offset, @Param(value = "size")Integer size);
    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param(value="userId")Integer userId);
   @Select("select * from question where id=#{id}")
    Question getById(@Param(value = "id") Integer id);

   @Update("update question set title = #{title},description = #{description},gmt_modified = #{gmtModified},tag = #{tag}")
    void update(Question question);
}
