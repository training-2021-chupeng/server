package cn.codingstyle.config;

public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
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
}
