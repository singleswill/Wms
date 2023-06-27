package com.wms.wms.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.wms.wms.common.core.controller.BaseController;
import com.wms.wms.common.core.result.BaseResponse;
import com.wms.wms.entity.Message;
import com.wms.wms.entity.WmsLedger;
import com.wms.wms.entity.WmsRespGoods;
import com.wms.wms.entity.WmsResposity;
import com.wms.wms.service.MessageService;
import com.wms.wms.service.WmsLedgerService;
import com.wms.wms.service.WmsRespGoodsService;
import com.wms.wms.service.WmsResposityService;
import com.wms.wms.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 仓库管理
 */
@RestController
@RequestMapping("/wmsResposity")
public class WmsResposityController extends BaseController
{
    @Resource
    private WmsResposityService wmsResposityService;

    @Resource
    private WmsLedgerService wmsLedgerService;

    @Resource
    private WmsRespGoodsService wmsRespGoodsService;

    @Resource
    private MessageService messageService;


    /**
     * 根据商品id统计商品数据
     */
    @GetMapping("/{id}")
    public BaseResponse countGoodsId(@PathVariable Integer id)
    {
        GoodsVo goodsVo = wmsResposityService.selectStockPriceById(id);
        if (goodsVo != null)
            return BaseResponse.success(goodsVo);
        return null;
    }

    /**
     * 入库
     */
    @PostMapping("/in")
    public BaseResponse addStock(@RequestBody WmsLedger wmsLedger)
    {
        wmsLedger.setRecordTime(new Date());
        wmsLedger.setRecordStatus(1);
        int rows = wmsRespGoodsService.edit(wmsLedger);
        if (rows > 0)
        {
            return toAjax(wmsLedgerService.save(wmsLedger) ? 1 : 0);
        }
        return BaseResponse.fail("入库失败");
    }
    /**
     * 出库
     */
    @PostMapping("/out")
    public BaseResponse outStock(@RequestBody WmsLedger wmsLedger)
    {
        wmsLedger.setRecordTime(new Date());
        wmsLedger.setRecordStatus(0);
        int rows = wmsRespGoodsService.edit(wmsLedger);
        if (rows > 0)
        {
            //消息记录到数据库中
            Message message = new Message();
            message.setContent("测试消息");
            message.setRecordTime(wmsLedger.getRecordTime());
            message.setGoodsId(wmsLedger.getGoodsId());
            message.setReadStatus(0);
            messageService.save(message);
            //推送消息给admin用户
//            sendMessageToAdmin(message);
            //设置定时任务判断3小时后消息是否已读
            if (false)
            {
                //  如果3小时后未读则发送短信给admin
//                sendSmsToAdmin(message);
            }

            return toAjax(wmsLedgerService.save(wmsLedger)?1:0);
        }
        return BaseResponse.fail("出库失败");
    }

}

