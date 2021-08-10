package cn.codingstyle.config;

import java.util.List;
import java.util.Optional;

public interface ReceiptItemRepository {
    void save(ReceiptItem receiptItem);

    Optional<ReceiptItem> getReceiptItem(String barcode);

    List<ReceiptItem> findAll();

    void clear();
}
