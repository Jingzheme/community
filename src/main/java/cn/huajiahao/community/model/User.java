package cn.huajiahao.community.model;


import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @Description TODO
 * @Date 2019/7/23 14:49
 * @Created by 11744
 */

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
