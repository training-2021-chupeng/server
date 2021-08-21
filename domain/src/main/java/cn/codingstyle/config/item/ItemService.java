package cn.codingstyle.config.item;

import cn.codingstyle.config.BusinessException;

import java.util.List;

public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void newItem(ItemRequest request) {
        checkBarcodeDup(request.getBarcode());
        Item item = request.toEntity();
        itemRepository.save(item);
    }


    public Item getItem(int id) {
        return itemRepository.findById(id).orElseThrow(() -> new BusinessException("Item with id: " + id + " do not exist"));
    }

    public void updateItem(int id, ItemRequest request) {
        itemRepository.findById(id).ifPresent(item -> updateItem(request, item));
    }

    private void updateItem(ItemRequest request, Item item) {
        if (!item.getBarcode().equals(request.getBarcode())) {
            checkBarcodeDup(request.getBarcode());
        }
        item.update(request.toEntity());
        itemRepository.save(item);
    }

    public void deleteItem(int id) {
        itemRepository.delete(id);
    }

    private void checkBarcodeDup(String barcode) {
        if (itemRepository.existByBarcode(barcode)) {
            throw new BusinessException("New item's barcode already exists.");
        }
    }


    public List<Item> getItemList() {
        return itemRepository.findAll();
    }
}
