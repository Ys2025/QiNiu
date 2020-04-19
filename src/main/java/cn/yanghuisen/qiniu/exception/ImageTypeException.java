package cn.yanghuisen.qiniu.exception;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 13:47
 * @Description 图片类型异常
 */
public class ImageTypeException extends RuntimeException {
    private Integer code;
    private String msg;

    public ImageTypeException() {
    }

    public ImageTypeException(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
