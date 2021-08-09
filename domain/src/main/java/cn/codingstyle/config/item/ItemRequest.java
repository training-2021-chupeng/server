package cn.codingstyle.config.item;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ItemRequest {
    private String barcode;
    private String name;
    private String unit;
    private BigDecimal price;
    private String type;

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .barcode(barcode)
                .price(price)
                .type(type)
                .unit(unit)
                .build();
    }
}