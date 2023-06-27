package com.wms.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.wms.entity.WmsGoods;

import java.util.List;

public interface WmsGoodsService extends IService<WmsGoods> {

    List<WmsGoods> selectByName(String name);

    boolean checkWmsGoodsNameUnique(WmsGoods wmsGoods);

    int deleteGoodsByIds(List<Long> idList);

    int insert(WmsGoods wmsGoods);

    boolean checkWmsNameUnique(WmsGoods wmsGoods);
}

