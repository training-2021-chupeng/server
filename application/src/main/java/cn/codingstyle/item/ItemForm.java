package cn.codingstyle.item;

import cn.codingstyle.config.ItemRequest;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemForm {
    private String barcode;
    private String name;
    private String unit;
    private BigDecimal price;
    private String type;

    public ItemRequest toRequest()
    {
        return ItemRequest.builder()
                .name(name)
                .barcode(barcode)
                .price(price)
                .type(type)
                .unit(unit)
                .build();
    }
}
