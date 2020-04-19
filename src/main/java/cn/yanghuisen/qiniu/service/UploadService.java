package cn.yanghuisen.qiniu.service;

import cn.yanghuisen.qiniu.entity.ImageData;
import cn.yanghuisen.qiniu.utils.FileType;
import cn.yanghuisen.qiniu.utils.QiNiuUtil;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 13:08
 * @Description TODO
 */

@Service
public class UploadService {

    public ImageData upload(MultipartFile file) throws IOException {
        // 验证图片格式是否满足要求
        FileType.isType(file.getContentType());
        // 获取上传管理器
        UploadManager uploadManager = QiNiuUtil.getUploadManager();
        // 调用图片上传功能
        DefaultPutRet putRet = QiNiuUtil.upload(uploadManager,file.getBytes());
        // 获取文件信息
        FileInfo info = QiNiuUtil.getFileInfo(putRet.key);
        ImageData data = new ImageData();
        data.setKey(putRet.key);
        data.setHash(info.hash);
        data.setPutTime(info.putTime);
        data.setMd5(info.md5);
        data.setFsize(info.fsize);
        return data;
    }
}
