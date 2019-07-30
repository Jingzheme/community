package cn.huajiahao.community.mapper;

import cn.huajiahao.community.model.User;
import org.apache.ibatis.annotations.*;


/**
 * @Description TODO
 * @Date 2019/7/23 14:47
 * @Created by 11744
 */

@Mapper
public interface  UserMapper {

    @Insert("insert into user (NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED,AVATAR_URL) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
     void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name},token = #{token},gmt_modified = #{gmtModified},avatar_url =#{avatarUrl} where id = #{id}")
    void update(User user);

}
