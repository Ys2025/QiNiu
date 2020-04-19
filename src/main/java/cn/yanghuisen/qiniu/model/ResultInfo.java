package cn.yanghuisen.qiniu.model;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 13:10
 * @Description TODO
 */
public class ResultInfo {
    private Integer code = 200;
    private String msg = "ok";
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
