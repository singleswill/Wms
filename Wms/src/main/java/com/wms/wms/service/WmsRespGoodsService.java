package com.wms.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.wms.entity.WmsLedger;
import com.wms.wms.entity.WmsRespGoods;

public interface WmsRespGoodsService extends IService<WmsRespGoods> {

    int edit(WmsLedger wmsLedger);

}

