package com.wms.wms.common.core.result;

/**
 * 分页参数封装
 **/
public class PageDomain
{

    /* 当前记录起始索引 */
    private Integer pageNum;

    /* 每页显示的记录数 */
    private Integer pageSize;

    /* 当前页 */
    private Integer pageCurrent;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCurrent()
    {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent)
    {
        this.pageCurrent = pageCurrent;
    }
}
