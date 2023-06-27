package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.wms.dao.WmsGoodsDao;
import com.wms.wms.entity.WmsGoods;
import com.wms.wms.service.WmsGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;


@Service("wmsGoodsService")
public class WmsGoodsServiceImpl extends ServiceImpl<WmsGoodsDao, WmsGoods> implements WmsGoodsService {

    @Resource
    private WmsGoodsDao wmsGoodsDao;
    @Override
    public List<WmsGoods> selectByName(String name)
    {
        List<WmsGoods> list = wmsGoodsDao.selectByName(name);
        return list;
    }

    @Override
    public boolean checkWmsGoodsNameUnique(WmsGoods wmsGoods)
    {
        WmsGoods wmsGoods1  = wmsGoodsDao.checkWmsGoodsNameUnique(wmsGoods);
        return wmsGoods1!=null;
    }

    @Override
    public boolean checkWmsNameUnique(WmsGoods wmsGoods)
    {
        WmsGoods wmsGoods1  = wmsGoodsDao.checkWmsNameUnique(wmsGoods);
        return wmsGoods1!=null;
    }

    @Override
    public int deleteGoodsByIds(List<Long> idList)
    {
        return wmsGoodsDao.deleteBatchIds(idList);
    }


    @Override
    public int insert(WmsGoods wmsGoods)
    {
        return wmsGoodsDao.insert(wmsGoods);
    }
}

