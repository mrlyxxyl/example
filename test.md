参数说明：


| 序号	| 参数            | 是否必填  | 参数名称         | 参数描述        | 实例          |
| -----		|:-------------: | -----:   |:-------------:  |:-------------:|:-------------:|
|  1       | page_number    | no       | 页码             | 默认1         | 1              |
|  2       | page_size      | no       | 每页查询数量      | 默认20        | 20             |


返回结果：

{						
  "message": "请求成功",						
  "result": 0,						
  "masters": [						
    {						
      "head_img": "http://img.ylznet.com/pictures/20160413/1460531479936_0f5c0e0e10.jpg",						
      "user_id": "123612742",						
      "pname": "张晓飞嗷嗷嗷",						
      "career": "这是十五字这是十五字这是十五字",						
      "is_crowd": 1,						
      "rq": 3270						
    },						
    {						
      "head_img": "http://img.zzdl.com/src_p/sj_pc/img/testImg/extra/test4.jpg",						
      "user_id": "123608917",						
      "pname": "测试9",						
      "career": "黄小帅",						
      "is_crowd": 0,						
      "rq": 46						
    }						
  ]						
}		


说明：

  result: 	0操作成功 1操作失败 3没有数据		
