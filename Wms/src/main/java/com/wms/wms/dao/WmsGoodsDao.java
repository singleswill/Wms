package com.wms.wms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.wms.entity.WmsGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface WmsGoodsDao extends BaseMapper<WmsGoods> {

    //  通过商品名称查询商品列表
    List<WmsGoods> selectByName(String name);

    //  检查商品id和名称是否已存在
    WmsGoods checkWmsGoodsNameUnique(WmsGoods wmsGoods);

    //  检查商品名称是否已存在
    WmsGoods checkWmsNameUnique(WmsGoods wmsGoods);
}

