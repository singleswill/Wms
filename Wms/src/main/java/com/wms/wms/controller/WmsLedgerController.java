package com.wms.wms.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.wms.common.core.controller.BaseController;
import com.wms.wms.common.core.result.BaseResponse;
import com.wms.wms.common.core.result.PageResult;
import com.wms.wms.entity.WmsLedger;
import com.wms.wms.service.WmsLedgerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.stream.events.StartDocument;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 台账管理
 */
@RestController
@RequestMapping("/wmsLedger")
public class WmsLedgerController extends BaseController
{
    @Resource
    private WmsLedgerService wmsLedgerService;

    /**
     * 商品入库流水查询
     */
    @GetMapping("/in")
    public PageResult selectAllIn(WmsLedger wmsLedger) {
        startPage();
        QueryWrapper<WmsLedger> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id",wmsLedger.getGoodsId()).gt("record_time",wmsLedger.getRecordTime()).eq("record_status",1);
        List<WmsLedger> list = wmsLedgerService.list(wrapper);
        return getData(list);
    }

    /**
     * 商品出库流水查询
     */
    @GetMapping("/out")
    public PageResult selectAllOut(WmsLedger wmsLedger) {
        startPage();
        QueryWrapper<WmsLedger> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id",wmsLedger.getGoodsId()).gt("record_time",wmsLedger.getRecordTime()).eq("record_status",0);
        List<WmsLedger> list = wmsLedgerService.list(wrapper);
        return getData(list);
    }

}

