package com.wms.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.wms.entity.WmsLedger;
import com.wms.wms.entity.WmsResposity;
import com.wms.wms.vo.GoodsVo;

public interface WmsResposityService extends IService<WmsResposity> {

    GoodsVo selectStockPriceById(Integer id);

}

