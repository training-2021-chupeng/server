Feature: 录入条码展示单据信息

  Scenario: 录入条码和数量
    Given 已存在商品信息
      | 条码       | 名称    | 单位 | 价格    | 类型 |
      | 82203001 | juice | L  | 13.60 | 1  |
      | 82203002 | rice  | KG | 7.09  | 1  |
    When 录入条码和数量
    """
    {
      "barcode":"82203001",
      "quantity":3
    }
    """
    Then 获得收据信息
    """
    {
	"totalAmount": 40.80,
	"receiptItems": [{
		"name": "juice",
		"price": 13.60,
		"totalPrice": 40.80,
		"quantity": 3
	}]
   }
    """

#  Scenario: 多次录入条码
#    Given 已存在商品信息
#      | 条码       | 名称    | 单位 | 价格    | 类型 |
#      | 82203001 | juice | L  | 13.60 | 1  |
#      | 82203002 | rice  | KG | 7.09  | 1  |
#    Given 录入条码和数量
#    """
#    {
#      "barcode":"82203001",
#      "quantity":3
#    }
#    """
#    When 录入条码和数量
#    """
#    {
#      "barcode":"82203001",
#      "quantity":3
#    }
#    """
#    Then 获得收据信息
#    """
#    {
#	"totalAmount": 81.60,
#	"receiptItems": [{
#		"name": "juice",
#		"price": 13.60,
#		"totalPrice": 81.60,
#		"quantity": 6
#	}]
#   }
#    """
