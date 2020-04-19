package cn.yanghuisen.qiniu.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 11:15
 * @Description  QiNiu工具类
 */
public class QiNiuUtil {

    public static Auth getAuth(){
        return Auth.create(QiNiuContent.accessKey,QiNiuContent.secretKey);
    }


    /**
     * 获取七牛upToken
     * @return upToken
     */
    public static String getUpToken(){
        Auth auth = getAuth();
        return auth.uploadToken(QiNiuContent.bucket);
    }

    /**
     * 获取配置器
     * @return 配置器
     */
    public static Configuration getConfiguration(){
        return new Configuration(Region.huadong());
    }


    /**
     * 获取七牛云UploadManager
     * @return UploadManager
     */
    public static UploadManager getUploadManager(){
        return new UploadManager(getConfiguration());
    }

    /**
     * file上传
     * @param uploadManager uploadManager
     * @param file  要上传的文件
     * @param key 要上传的文件名 如果为null，则文件名为hash值
     * @throws QiniuException   异常
     */
    public static DefaultPutRet upload(UploadManager uploadManager, File file,String key) throws QiniuException {
        Response response = uploadManager.put(file,key, getUpToken());
        // 解析上传成功的结果
        return new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
    }

    /**
     *
     * @param uploadManager uploadManager
     * @param bytes 要上传的文件的字节数组
     * @throws QiniuException 异常
     */
    public static DefaultPutRet upload(UploadManager uploadManager, byte[] bytes) throws QiniuException {
        Response response = uploadManager.put(bytes,null, getUpToken());
        // 解析上传成功的结果
        return new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
    }


    public static FileInfo getFileInfo(String key) throws QiniuException {
        // 获取管理器
        BucketManager manager = new BucketManager(getAuth(),getConfiguration());
        // 获取文件信息
        return manager.stat(QiNiuContent.bucket,key);
    }

}
