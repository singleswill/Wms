package com.wms.wms.common.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wms.wms.common.constant.HttpStatus;
import com.wms.wms.common.core.result.BaseResponse;
import com.wms.wms.common.core.result.PageDomain;
import com.wms.wms.common.core.result.PageResult;
import com.wms.wms.common.utils.ServletUtils;

import java.util.List;

/**
 * 基础控制器类
 **/
public class BaseController
{

    /* 当前记录起始索引 */
    public static final String PAGE_NUM = "pageNum";

    /* 每页显示记录数 */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 分装分页数据
     */
    public static PageDomain getPageDomain(){

        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        return pageDomain;
    }


    /**
     * 封装调用PageHelper的startPage方法
     */
    protected void startPage(){

        PageDomain pageDomain = getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
    }

    /**
     * 响应分页数据
     * @param list
     * @return
     */
    protected PageResult getData(List<?> list){

        PageResult pageResult = new PageResult();
        pageResult.setCode(HttpStatus.SUCCESS);
        pageResult.setMsg("分页查询成功");
        pageResult.setCurrent(getPageDomain().getPageNum());
        pageResult.setSize(getPageDomain().getPageSize());
        pageResult.setTotal(new PageInfo(list).getTotal());
        pageResult.setData(list);
        return  pageResult;
    }


    /**
     * 响应返回结果 （针对增删改 操作）
     * @param rows  受影响的行数
     * @return
     */
    protected BaseResponse toAjax(int rows){

        return rows > 0 ? BaseResponse.success(rows) : BaseResponse.fail("操作失败");
    }
}
