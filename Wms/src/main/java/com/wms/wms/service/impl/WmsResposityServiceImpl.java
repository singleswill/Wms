package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.wms.dao.WmsResposityDao;
import com.wms.wms.entity.WmsLedger;
import com.wms.wms.entity.WmsResposity;
import com.wms.wms.service.WmsResposityService;
import com.wms.wms.vo.GoodsVo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Service("wmsResposityService")
public class WmsResposityServiceImpl extends ServiceImpl<WmsResposityDao, WmsResposity> implements WmsResposityService {

    @Resource
    private WmsResposityDao wmsResposityDao;
    @Override
    public GoodsVo selectStockPriceById(Integer id)
    {
        GoodsVo goodsVo = wmsResposityDao.selectStockPriceById(id);
        return goodsVo;
    }

}

