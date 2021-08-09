Feature: 商品管理

  Scenario: 新增商品
    When 新增商品信息
    """
    {
      "barcode":"12345678",
      "name":"juice",
      "unit":"L",
      "price":13.60,
      "type": "1"
    }
    """
    Then 有商品信息
      | 条码       | 名称    | 单位 | 价格    | 类型 |
      | 12345678 | juice | L  | 13.60 | 1  |

  Scenario: 更新商品
    Given 已存在商品信息
      | 条码       | 名称   | 单位 | 价格   | 类型 |
      | 82203002 | rice | KG | 7.09 | 1  |
    When 更新商品"1"信息
    """
    {
      "barcode":"82203002",
      "name":"juice",
      "unit":"L",
      "price":13.60,
      "type": "1"
    }
    """
    Then 有商品信息
      | 条码       | 名称    | 单位 | 价格    | 类型 |
      | 82203002 | juice | L  | 13.60 | 1  |

  Scenario: 根据id获取商品信息
    Given 已存在商品信息
      | 条码       | 名称   | 单位 | 价格   | 类型 |
      | 82203002 | rice | KG | 7.09 | 1  |
    When 根据id "1" 查询商品
    Then 得到商品信息
      | 条码       | 名称   | 单位 | 价格   | 类型 |
      | 82203002 | rice | KG | 7.09 | 1  |

  Scenario: 删除指定商品信息
    Given 已存在商品信息
      | 条码       | 名称   | 单位 | 价格   | 类型 |
      | 82203002 | rice | KG | 7.09 | 1  |
    When 根据id "1" 删除商品
    Then id 为 "1" 的商品不存在

