package cn.codingstyle.config;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
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