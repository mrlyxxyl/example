# 用户添加对话(历知)

## 请求

+ 请求方式：`HTTP` `POST`
+ 请求地址：历知url    /api/secretary/add
+ 请求参数：

| 参数名称 | 可选性 | 参数说明|
|------:|:------:|:------:|
| 历知公共参数 |  必须 | [公共参数说明](http://git.etouch.cn/gitbucket/suishen_cloud_server/cloud_server_doc/blob/master/wecal_api/%E5%8E%86%E7%9F%A5%E6%8E%A5%E5%8F%A3%E5%85%AC%E5%85%B1%E5%8F%82%E6%95%B0.md) |
| content |  必须 | 内容 |
| info | 必须 | 信息 |

 + content内容格式[用户消息]

 ```
 {
    "type": "text:0/image:1"
    "text":,
    "image":["",""...]
 }
 ```
 + info内容格式[用户手机信息]

 ```
 {
    "os":操作系统 如 "Android",
    "osVersion":操作系统版本号 "2.3.7",
    "appVersion":应用的版本号"4.5.6",
    "deviceModel":设备型号"MB5252",
    "resolution":分辨率"480*854",
    "access":接入的网络，如"Wi-Fi",
    "carrier":运营商，CMCC（中国移动）、CUCC（中国联通）、CTCC（中国电信）,
    "channel":应用分发渠道"UMENG",
    "lat":纬度,
    "lon":经度,
    "cityId":城市的cityKey,
    "pkg":应用的包名,
    "vercode":版本号去掉中间的小数点如456，和app_version=4.5.6对应的,
    "cup":"ARMv7 Processor rev 2(v71)",
    "appkey":应用key,	
    "sdkVersion":sdk版本号,
    "country":国家"CN",
    "timezone":8,
    "language":"zh"
 }
 ```
 ----
## 响应

 + 响应内容格式
(未完待续)
