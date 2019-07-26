package cn.huajiahao.community.model;

import lombok.Data;

/**
 * @Description TODO
 * @Date 2019/7/24 17:00
 * @Created by 11744
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

}