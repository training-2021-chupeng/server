package cn.codingstyle.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemService {
    private ItemRepository itemRepository;
    private List<ReceiptItem> receiptItems;
    private ReceiptItemRepository receiptItemRepository;

    public ItemService(ItemRepository itemRepository, ReceiptItemRepository receiptItemRepository) {
        this.itemRepository = itemRepository;
        receiptItems = new ArrayList<>();
        this.receiptItemRepository = receiptItemRepository;
    }

    public void newItem(ItemRequest request) {
        Item item = request.toEntity();
        itemRepository.save(item);
    }

    public Item getItem(int id) {
        return itemRepository.findById(id).get();
    }

    public void updateItem(int id, ItemRequest request) {
        itemRepository.findById(id).ifPresent(item -> {
            item.update(request.toEntity());
            itemRepository.save(item);
        });
    }

    public void deleteItem(int id) {
        itemRepository.delete(id);
    }

    public Receipt inputBarcode(String barcode, Integer quantity) {
        Item item = itemRepository.findByBarcode(barcode).get();
        ReceiptItem receiptItem = new ReceiptItem(item, quantity);
        addItem(receiptItem);
        return new Receipt(receiptItemRepository.findAll());
    }

    private void addItem(ReceiptItem receiptItem) {
        Optional<ReceiptItem> first = receiptItemRepository.getReceiptItem(receiptItem.getBarcode());
        if (first.isPresent()) {
            ReceiptItem item = first.get();
            item.addQuantity(receiptItem.getQuantity());
        } else {
            receiptItemRepository.save(receiptItem);
        }
    }

}
