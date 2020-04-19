package cn.yanghuisen.qiniu;

import cn.yanghuisen.qiniu.exception.ImageTypeException;
import cn.yanghuisen.qiniu.model.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 指定异常
    @ExceptionHandler(ImageTypeException.class)
    @ResponseBody
    public ResultInfo ex1(ImageTypeException e){

        ResultInfo info = new ResultInfo();
        info.setCode(e.getCode());
        info.setMsg(e.getMsg());
        return info;
    }


    @ExceptionHandler
    @ResponseBody
    public ResultInfo exAll(Exception e){
        ResultInfo info = new ResultInfo();
        info.setCode(400);
        info.setMsg("系统错误，请稍后再试...");
        return info;
    }
}
