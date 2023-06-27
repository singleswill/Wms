package com.wms.wms.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.wms.common.core.controller.BaseController;
import com.wms.wms.common.core.result.BaseResponse;
import com.wms.wms.common.core.result.PageResult;
import com.wms.wms.entity.Message;
import com.wms.wms.service.MessageService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 消息管理
 */
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController
{

    @Resource
    private MessageService messageService;



    /**
     * 消息列表
     */
    @GetMapping
    public PageResult list(@DateTimeFormat(pattern = "yyyy-MM-ss HH:mm:ss") Date startTime,@DateTimeFormat(pattern = "yyyy-MM-ss HH:mm:ss") Date endTime)
    {
        startPage();
        //  如果为admin 看到未读的消息
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        //  直接写是admin用户
        if(true)
        {
            wrapper.eq("read_status",0);
            List<Message> list = messageService.list(wrapper);
            return getData(list);
        }
        // 如果是普通用户
        wrapper.ge("record_time","'"+startTime+"'").le("record_time","'"+endTime+"'");
        List<Message> list = messageService.list(wrapper);
        return getData(list);
    }
    /**
     * 读取消息
     */
    @GetMapping("/{id}")
    public BaseResponse readMessage(@PathVariable Integer id)
    {
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        Message byId = messageService.getById(id);
        //  将消息设为已读
        byId.setReadStatus(1);
        messageService.updateById(byId);
        return BaseResponse.success(byId);
    }
}

