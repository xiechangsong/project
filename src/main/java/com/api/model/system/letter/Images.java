package com.api.model.system.letter;

/**
 * Created by Administrator on 2017/7/25.
 */
public class Images {
    private  int imageId;
    private  String imageUrl;//图片地址
    private  String linkAddress;//图链接地址
    private  String title;//图标题
    private  String type;//图片类型
    private  int seriesNumber;//序列号
    private  String previewUrl;//略缩图片地址
    private  String color;//背景色
    private  String describes;//图片描述

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(int seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
