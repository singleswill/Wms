package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.wms.dao.WmsLedgerDao;
import com.wms.wms.entity.WmsLedger;
import com.wms.wms.service.WmsLedgerService;
import org.springframework.stereotype.Service;

@Service("wmsLedgerService")
public class WmsLedgerServiceImpl extends ServiceImpl<WmsLedgerDao, WmsLedger> implements WmsLedgerService {

}

