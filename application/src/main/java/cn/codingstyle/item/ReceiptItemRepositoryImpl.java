package cn.codingstyle.item;

import cn.codingstyle.config.ReceiptItem;
import cn.codingstyle.config.ReceiptItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReceiptItemRepositoryImpl implements ReceiptItemRepository {
    private final List<ReceiptItem> receiptItems = new ArrayList<>();

    @Override
    public void save(ReceiptItem receiptItem) {
        receiptItems.add(receiptItem);
    }

    @Override
    public Optional<ReceiptItem> getReceiptItem(String barcode) {
        return receiptItems.stream()
                .filter(item -> item.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public List<ReceiptItem> findAll() {
        return receiptItems;
    }

    @Override
    public void clear() {
        receiptItems.clear();
    }
}
