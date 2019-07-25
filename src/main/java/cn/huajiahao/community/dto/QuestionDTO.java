package cn.huajiahao.community.dto;

import cn.huajiahao.community.model.User;
import lombok.Data;

/**
 * @Description TODO
 * @Date 2019/7/25 14:58
 * @Created by 11744
 */
@Data
public class QuestionDTO {
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
    private User user;
}
