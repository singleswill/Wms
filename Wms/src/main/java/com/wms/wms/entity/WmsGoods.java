package com.wms.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品表实体类
 */
@SuppressWarnings("serial")
public class WmsGoods implements Serializable {
    //商品ID（身份标识）
    @TableId(type = IdType.AUTO)
    private Integer goodsId;
    //商品名称
    @NotNull
    private String goodsName;
    //类型
    @NotNull
    private String goodsType;
    //商品规格
    @NotNull
    private String goodsSize;
    //商品单价
    @NotNull
    private Double goodsPrice;


    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    }
    


