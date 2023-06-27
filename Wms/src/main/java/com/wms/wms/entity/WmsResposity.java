package com.wms.wms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 仓库表实体类
 */
//@SuppressWarnings("serial")
public class WmsResposity implements Serializable {
    //仓库id
    @TableId
    private Integer respId;
    //仓库名称
    @NotNull
    private String respName;
    //仓库地址
    @NotNull
    private String respAddress;


    public Integer getRespId() {
        return respId;
    }

    public void setRespId(Integer respId) {
        this.respId = respId;
    }

    public String getRespName() {
        return respName;
    }

    public void setRespName(String respName) {
        this.respName = respName;
    }

    public String getRespAddress() {
        return respAddress;
    }

    public void setRespAddress(String respAddress) {
        this.respAddress = respAddress;
    }


    }

