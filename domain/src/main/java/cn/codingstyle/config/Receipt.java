package cn.codingstyle.config;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class Receipt {
    private BigDecimal totalAmount;
    private List<ReceiptItem> receiptItems;

    public Receipt(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
        this.totalAmount = receiptItems.stream().map(ReceiptItem::getTotalPrice).reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }
}
