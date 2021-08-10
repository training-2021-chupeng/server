package cn.codingstyle.config;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Java6Assertions.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    /**
     * 录入一个商品
     * 录入一个重复商品
     * 录入多个商品
     *
     */

    @Test
    void 录入一个商品() {
        Receipt receipt = new Receipt(
                Arrays.asList(
                        new ReceiptItem("juice", "12345678", valueOf(13.60), valueOf(13.60), 1)
                )
        );
        List<ReceiptItem> receiptItems = receipt.getReceiptItems();
        assertThat(receiptItems.size()).isEqualTo(1);
        ReceiptItem receiptItem = receiptItems.get(0);
        assertThat(receiptItem.getName()).isEqualTo("juice");
        assertThat(receiptItem.getPrice()).isEqualTo(valueOf(13.60));
        assertThat(receiptItem.getTotalPrice()).isEqualTo(valueOf(13.60));
        assertThat(receiptItem.getQuantity()).isEqualTo(1);
        assertThat(receipt.getTotalAmount()).isEqualTo(valueOf(13.60));
    }
}
