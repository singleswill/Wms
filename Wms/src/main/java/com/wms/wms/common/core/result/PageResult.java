package com.wms.wms.common.core.result;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 分页查询统一响应封装
 **/
public class PageResult implements Serializable {

    private static final long serialVersionUID = 3569196449974963450L;

    /** 总记录数 */
    private long total;
    /** 每页数据量 **/
    private long size;

    private long current;

    /** 列表数据 */
    private List<?> data;

    /** 消息状态码 */
    private Integer code;

    /** 消息内容 */
    private String msg;

    public PageResult() {
    }

    /***
     * 分页
     * @param total 总记录数
     * @param rows  列表数据
     * @return
     */
    public PageResult(long total, List<?> data) {
        this.total = total;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public long getCurrent()
    {
        return current;
    }

    public void setCurrent(long current)
    {
        this.current = current;
    }
}
