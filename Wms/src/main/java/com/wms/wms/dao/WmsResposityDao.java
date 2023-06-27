package com.wms.wms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.wms.entity.WmsResposity;
import com.wms.wms.vo.GoodsVo;


public interface WmsResposityDao extends BaseMapper<WmsResposity> {

    //  通过商品id查询商品库存和商品价格
    GoodsVo selectStockPriceById(Integer id);
}

