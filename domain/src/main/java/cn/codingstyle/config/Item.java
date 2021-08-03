package cn.codingstyle.config;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Item {
    private int id;
    private String barcode;
    private String name;
    private String unit;
    private BigDecimal price;
    private String type;

    public void update(Item item) {
        this.barcode = item.getBarcode();
        this.name = item.getName();
        this.unit = item.getUnit();
        this.price = item.getPrice();
        this.type = item.getType();
    }
}
