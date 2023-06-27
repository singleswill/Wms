package com.wms.wms.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.wms.common.core.controller.BaseController;
import com.wms.wms.common.core.result.BaseResponse;
import com.wms.wms.common.core.result.PageResult;
import com.wms.wms.entity.WmsGoods;
import com.wms.wms.service.WmsGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品管理
 */
@RestController
@RequestMapping("/wmsGoods")
public class WmsGoodsController extends BaseController
{
    /**
     * 服务对象
     */
    @Resource
    private WmsGoodsService wmsGoodsService;

    /**
     * 分页商品所有数据
     * @return 所有商品
     */
    @RequestMapping("/list")
    public PageResult selectAll() {
        startPage();
        List<WmsGoods> list = wmsGoodsService.list();
        return getData(list);
    }

    /**
     * 通过商品名称查询数据
     */
    @GetMapping(value = "/listByName")
    public PageResult selectOne(@RequestParam(value = "name") String name) {
        startPage();
        List<WmsGoods> list = wmsGoodsService.selectByName(name);
        return getData(list);
    }

    /**
     * 新增商品
     */
    @PostMapping
    public BaseResponse insert(@RequestBody WmsGoods wmsGoods) {
        if (wmsGoodsService.checkWmsGoodsNameUnique(wmsGoods))
        {
            return BaseResponse.fail("新增商品失败,商品名称或id已经存在");
        }
        return toAjax(wmsGoodsService.insert(wmsGoods));
    }

    /**
     * 修改商品名称
     */
    @PutMapping
    public BaseResponse update(@RequestBody WmsGoods wmsGoods) {
        if (wmsGoodsService.checkWmsNameUnique(wmsGoods))
        {
            return BaseResponse.fail("修改商品名称失败,商品名称类型已经存在");
        }
        return toAjax(wmsGoodsService.updateById(wmsGoods) ? 1:0);
    }

    /**
     * 删除数据
     */
    @DeleteMapping("/{goodIds}")
    public BaseResponse delete(@PathVariable("goodIds") List<Long> goodIds) {
        return toAjax(wmsGoodsService.deleteGoodsByIds(goodIds));
    }
}

