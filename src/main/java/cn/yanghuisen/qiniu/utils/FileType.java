package cn.yanghuisen.qiniu.utils;

import cn.yanghuisen.qiniu.exception.ImageTypeException;

import java.util.*;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 13:41
 * @Description TODO
 */
public class FileType {
    public static Set<String> types;
    static {
        types = new HashSet<>();
        types.add("image/gif");
        types.add("image/jpeg");
        types.add("image/png");
    }

    /**
     * 验证文件格式是否满足要求
     * @param type 图片类型
     */
    public static void isType(String type){
        if (!types.contains(type)){
            throw new ImageTypeException("不支持的图片类型");
        }
    }
}
