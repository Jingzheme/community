package cn.huajiahao.community.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Date 2019/7/22 17:31
 * @Created by 11744
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
