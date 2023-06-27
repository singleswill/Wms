package com.wms.wms.vo;

import java.io.Serializable;

//统计商品信息
public class GoodsVo implements Serializable
{
    private String goodsId;

    private Integer stock;

    private Double goodsPrice;

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void setStock(Integer stock)
    {
        this.stock = stock;
    }

    public Double getGoodsPrice()
    {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }
}
