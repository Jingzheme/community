package cn.huajiahao.community.exception;

/**
 * @Description TODO
 * @Date 2019/7/31 16:22
 * @Created by 11744
 */
public class CustomizeException extends  RuntimeException{
    private String message;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
