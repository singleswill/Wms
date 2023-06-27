package com.wms.wms.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 台账表实体类
 */
//@SuppressWarnings("serial")
public class WmsLedger implements Serializable {
    //id
    @TableId(type = IdType.AUTO)
    private Integer ledgerId;
    //商品id
    @NotNull
    private Integer goodsId;
    //仓库id
    @NotNull
    private Integer respId;
    //交易数量
    @NotNull
    private Integer number;
    //入库/出库时间
    @DateTimeFormat(pattern = "yyyy-MM-ss HH:mm:ss")
    private Date recordTime;
    //入库or出库
    @NotNull
    private Integer recordStatus;


    public Integer getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(Integer ledgerId) {
        this.ledgerId = ledgerId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getRespId() {
        return respId;
    }

    public void setRespId(Integer respId) {
        this.respId = respId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getRecordStatus()
    {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus)
    {
        this.recordStatus = recordStatus;
    }
}

