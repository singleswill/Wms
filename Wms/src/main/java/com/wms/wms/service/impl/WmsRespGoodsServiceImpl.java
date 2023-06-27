package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.wms.dao.WmsRespGoodsDao;
import com.wms.wms.entity.WmsLedger;
import com.wms.wms.entity.WmsRespGoods;
import com.wms.wms.service.WmsRespGoodsService;
import org.apache.tomcat.jni.Sockaddr;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("wmsRespGoodsService")
public class WmsRespGoodsServiceImpl extends ServiceImpl<WmsRespGoodsDao, WmsRespGoods> implements WmsRespGoodsService {
    @Resource
    private WmsRespGoodsDao wmsRespGoodsDao;

    @Override
    public int edit(WmsLedger wmsLedger)
    {
        WmsRespGoods wmsRespGoods = new WmsRespGoods();
        wmsRespGoods.setGoodsId(wmsLedger.getGoodsId());
        wmsRespGoods.setRespId(wmsLedger.getRespId());
        QueryWrapper<WmsRespGoods> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id",wmsRespGoods.getGoodsId()).eq("resp_id",wmsRespGoods.getRespId());
        WmsRespGoods one = this.getOne(wrapper);
        //判断是出库还是入库
        if (1 == wmsLedger.getRecordStatus())
        {
            if (one == null)
            {
                return wmsRespGoodsDao.insert(wmsRespGoods);
            }
            wmsRespGoods.setStock(one.getStock()+wmsLedger.getNumber());
            wmsRespGoods.setId(one.getId());
            return wmsRespGoodsDao.updateById(wmsRespGoods);
        }else if (0 == wmsLedger.getRecordStatus())
        {
            if (one == null)
            {
                return 0;
            }
            int stock = one.getStock()-wmsLedger.getNumber();
            //  库存小于0返回失败
            if (stock < 0)
                return 0;
            wmsRespGoods.setStock(stock);
            wmsRespGoods.setId(one.getId());
            return wmsRespGoodsDao.updateById(wmsRespGoods);
        }
        return 0;
    }

}

