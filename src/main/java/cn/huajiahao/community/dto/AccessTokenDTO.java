package cn.huajiahao.community.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Date 2019/7/22 16:59
 * @Created by 11744
 */

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;

}
