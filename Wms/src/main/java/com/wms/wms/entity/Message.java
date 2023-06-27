package com.wms.wms.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 消息表实体类
 */
//@SuppressWarnings("serial")
public class Message implements Serializable {
    //id
    @TableId
    private Integer messageId;
    //商品id（身份标识）
    @NotNull
    private Integer goodsId;
    //出库时间
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-ss HH:mm:ss")
    private Date recordTime;
    //消息正文
    @NotNull
    private String content;
    //阅读状态（0-未读，1-已读）
    @NotNull
    private Integer readStatus;


    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    }

