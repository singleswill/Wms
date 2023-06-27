# 说明

## 数据库

- **商品表**：wms_goods

  | 字段名称    | 字段类型 | 是否为空值 | 注释               |
  | ----------- | -------- | ---------- | ------------------ |
  | goods_id    | int      | false      | 商品ID（身份标识） |
  | goods_name  | varchar  | false      | 商品名称           |
  | goods_type  | varchar  | false      | 商品类型           |
| goods_size  | varchar  | false      | 商品规格           |
  | goods_price | double   | false      | 商品单价           |
  
- **仓库信息表**：wms_resposity

  | 字段名称     | 字段类型 | 是否为空值 | 注释     |
  | ------------ | -------- | ---------- | -------- |
  | resp_id      | int      | false      | 仓库id   |
  | resp_name    | varchar  | false      | 仓库名称 |
  | resp_address | varchar  | false      | 仓库地址 |

- **仓库商品数量表**：wms_resp_goods

  | 字段名称 | 字段类型 | 是否为空值 | 注释     |
  | -------- | -------- | ---------- | -------- |
  | id       | int      | false      | id       |
  | resp_id  | int      | false      | 仓库id   |
  | stock    | int      | false      | 库存数量 |
  | goods_id | int      | false      | 商品id   |

  

- **台账表**：wms_ledger

  | 字段名称      | 字段类型 | 是否为空值 | 注释                        |
  | ------------- | -------- | ---------- | --------------------------- |
  | ledger_id     | int      | false      | id                          |
  | goods_id      | int      | false      | 商品id                      |
  | resp_id       | int      | false      | 仓库id                      |
  | number        | int      | false      | 交易数量                    |
  | record_time   | datatime | false      | 入库/出库时间               |
  | record_status | int      | alse       | 入库/出库（0-出库，1-入库） |

- **消息表**：message

  | 字段名称    | 字段类型 | 是否为空值 | 注释                       |
  | ----------- | -------- | ---------- | -------------------------- |
  | message_id  | int      | false      | id                         |
  | goods_id    | int      | false      | 商品id（身份标识）         |
  | record_time | int      | false      | 出库时间                   |
  | content     | text     | false      | 消息正文                   |
  | read_status | int      | false      | 阅读状态（0-未读，1-已读） |

## 接口文档

### 商品模块

**接口地址**：http://127.0.0.1:8888/wmsGoods/list?pageNum=2&pageSize=1
**请求方式**：GET
**接口描述**：根据当前页和页面数据量 查询全部商品
**请求参数说明**：

| 参数名称 | 参数说明     |
| -------- | ------------ |
| pageNum  | 当前页       |
| pageSize | 每页显示条数 |

**接口地址**：http://127.0.0.1:8888/wmsGoods/listByName?pageNum=2&pageSize=1&name=iphone
**请求方式**：GET
**接口描述**：根据当前页和页面数据量 查询全部商品
**请求参数说明**：

| 参数名称 | 参数说明     |
| -------- | ------------ |
| pageNum  | 当前页       |
| pageSize | 每页显示条数 |
| name     | 商品名称     |

**接口地址**：http://127.0.0.1:8888/wmsGoods
**请求方式**：POST
**接口描述**： 添加商品数据
**请求参数说明**：

| 参数名称   | 参数说明                   |
| ---------- | -------------------------- |
| goodsId    | 商品id（传参时可加可不加） |
| goodsName  | 商品名称                   |
| goodsType  | 商品类型                   |
| goodsSize  | 商品规格                   |
| goodsPrice | 商品单价                   |

```
{
    "goodsId":3,
    "goodsName":"iphone13",
    "goodsType":"手机",
    "goodsSize":"1",
    "goodsPrice":1000
}
```

**接口地址**：http://127.0.0.1:8888/wmsGoods
**请求方式**：PUT
**接口描述**：通过商品ID修改数据
**请求参数说明**：

| 参数名称   | 参数说明       |
| ---------- | -------------- |
| goodsId    | 要修改的商品id |
| goodsName  | 商品名称       |
| goodsType  | 商品类型       |
| goodsSize  | 商品规格       |
| goodsPrice | 商品单价       |

**接口地址**：http://127.0.0.1:8888/wmsGoods/3,4
**请求方式**：DELETE
**接口描述**：通过商品ID删除数据
**请求参数说明**：

| 参数名称 | 参数说明       |
| -------- | -------------- |
| goodsId  | 要修改的商品id |

### 台账模块

**接口地址**：http://127.0.0.1:8888/wmsLedger/in?goodsId=1&recordTime=2023-06-25 21:34:31&recordStatus=1&pageNum=2&pageSize=1
**请求方式**：GET
**接口描述**：根据当前页和页面数据量 通过商品ID、入库时间、出入库状态修改数据（查询入库数据）
**请求参数说明**：

| 参数名称     | 参数说明                 |
| ------------ | ------------------------ |
| goodsId      | 要查询的商品id           |
| recordTime   | 查询当前日期之后的数据   |
| recordStatus | 判断是出库还是入库的数据 |
| pageNum      | 当前页                   |
| pageSize     | 每页显示条数             |

**接口地址**：http://127.0.0.1:8888/wmsLedger/out?goodsId=1&recordTime=2023-06-25 21:34:31&recordStatus=0&pageNum=2&pageSize=1
**请求方式**：GET
**接口描述**：根据当前页和页面数据量 通过商品ID、出库时间、出入库状态修改数据（查询出库数据）
**请求参数说明**：

| 参数名称     | 参数说明                 |
| ------------ | ------------------------ |
| goodsId      | 要查询的商品id           |
| recordTime   | 查询当前日期之后的数据   |
| recordStatus | 判断是出库还是入库的数据 |
| pageNum      | 当前页                   |
| pageSize     | 每页显示条数             |

**接口地址**：http://127.0.0.1:8888/wmsResposity/1
**请求方式**：GET
**接口描述**：根据商品id统计商品数据
**请求参数说明**：

| 参数名称 | 参数说明       |
| -------- | -------------- |
| goodsId  | 要查询的商品id |

### 消息模块

**接口地址**：http://127.0.0.1:8888/message?pageNum=2&pageSize=1&startTime=2023-06-27 10:05:40&endTime=2023-06-27 10:05:50
**请求方式**：GET
**接口描述**：消息列表
**请求参数说明**：（admin用户可不传起始时间和结束时间）

| 参数名称  | 参数说明       |
| --------- | -------------- |
| startTime | 要查询的商品id |
| en'd'Time | 结束时间       |
| pageNum   | 当前页         |
| pageSize  | 每页显示条数   |

```
    "total": 1,
    "size": 1,
    "current": 2,
    "data": [
        {
            "messageId": 1,
            "goodsId": 1,
            "recordTime": "2023-06-27T02:05:47.000+00:00",
            "content": "c测试",
            "readStatus": 0
        }
    ],
    "code": 200,
    "msg": "分页查询成功"
}
```

**接口地址**：http://127.0.0.1:8888/message/1
**请求方式**：GET
**接口描述**：读取消息
**请求参数说明**：

| 参数名称 | 参数说明       |
| -------- | -------------- |
| id       | 要查询的消息id |