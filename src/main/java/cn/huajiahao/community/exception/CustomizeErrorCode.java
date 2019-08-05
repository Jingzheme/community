package cn.huajiahao.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找到的问题不在了，要不要换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题和评论进行回复。"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试。"),
    SYS_ERROR(2004,"服务冒烟了，不然哥们你等会儿试试......"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或者不存在。"),
    COMMETN_NOT_FOUND(2006,"你操作的评论不存在。");
    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() { return code; }


}
