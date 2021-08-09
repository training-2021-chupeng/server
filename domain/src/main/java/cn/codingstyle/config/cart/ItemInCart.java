package cn.codingstyle.config.cart;

import cn.codingstyle.config.item.Item;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemInCart {
    private String name;
    private int num;
    private BigDecimal price;
    private String barcode;
    private BigDecimal totalPrice;

    public ItemInCart(Item item, int num) {
        this.barcode = item.getBarcode();
        this.name = item.getName();
        this.num = num;
        this.price = item.getPrice();
        this.totalPrice = item.getPrice().multiply(BigDecimal.valueOf(num));
    }

    public void add(int add) {
        num += add;
        this.totalPrice = price.multiply(BigDecimal.valueOf(num));
    }
}
