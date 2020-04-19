package cn.yanghuisen.qiniu.entity;

/**
 * @author admin
 * @version 1.0
 * @date 2020/4/19 13:11
 * @Description 图片实体类
 */
public class ImageData {
    public String key;
    public String hash;
    public long fsize;
    public long putTime;
    public String md5;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getFsize() {
        return fsize;
    }

    public void setFsize(long fsize) {
        this.fsize = fsize;
    }

    public long getPutTime() {
        return putTime;
    }

    public void setPutTime(long putTime) {
        this.putTime = putTime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
