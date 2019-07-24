package cn.huajiahao.community.mapper;

import cn.huajiahao.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description TODO
 * @Date 2019/7/23 14:47
 * @Created by 11744
 */

@Mapper
public interface  UserMapper {
    @Insert("insert into user (NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
     void insert(User user);

}
