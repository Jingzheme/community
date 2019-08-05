package cn.huajiahao.community.exception;

/**
 * @Description TODO
 * @Date 2019/7/31 16:22
 * @Created by 11744
 */
public class CustomizeException extends  RuntimeException{
    private  Integer code;
    private String message;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public  Integer getCode(){ return code;}
}
