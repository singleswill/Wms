package com.wms.wms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品与仓库中间表实体类
 */
//@SuppressWarnings("serial")
public class WmsRespGoods implements Serializable {
    //id
    @TableId
    private Integer id;
    //仓库id
    @NotNull
    private Integer respId;
    //库存数量
    @NotNull
    private Integer stock;
    //商品id
    @NotNull
    private Integer goodsId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRespId() {
        return respId;
    }

    public void setRespId(Integer respId) {
        this.respId = respId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    }

