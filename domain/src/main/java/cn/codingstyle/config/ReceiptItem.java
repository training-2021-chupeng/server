package cn.codingstyle.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ReceiptItem {
    private String name;
    private String barcode;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private Integer quantity;

    public ReceiptItem(Item item, Integer quantity) {
        this.name = item.getName();
        this.barcode = item.getBarcode();
        this.price = item.getPrice();
        this.totalPrice = item.getPrice().multiply(BigDecimal.valueOf(quantity));
        this.quantity = quantity;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
        this.totalPrice = this.price.multiply(BigDecimal.valueOf(this.quantity));
    }
}
