package cn.codingstyle.config;

import java.util.Optional;

public class ItemService {
    private ItemRepository itemRepository;
    private ReceiptItemRepository receiptItemRepository;

    public ItemService(ItemRepository itemRepository, ReceiptItemRepository receiptItemRepository) {
        this.itemRepository = itemRepository;
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
        /**
         * barcode -> item
         * item,quantity -> receiptItem
         * receiptItem -> receipt
         *
         */
        Item item = itemRepository.findByBarcode(barcode).get();
        addItem(new ReceiptItem(item, quantity));
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
