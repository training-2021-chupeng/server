package cn.codingstyle.item;

import cn.codingstyle.config.item.Item;
import cn.codingstyle.config.item.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemDAO itemDAO;

    public ItemRepositoryImpl(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    public void save(Item item) {
        ItemDO itemDO = ItemDO.from(item);
        itemDAO.save(itemDO);
    }

    @Override
    public Optional<Item> findById(int id) {
        return itemDAO.findById(id).map(ItemDO::toEntity);
    }

    @Override
    public void delete(int id) {
        itemDAO.deleteById(id);
    }

    @Override
    public boolean existByBarcode(String barcode) {
        return itemDAO.existsByBarcode(barcode);
    }

    @Override
    public boolean existById(int id) {
        return itemDAO.existsById(id);
    }

    @Override
    public Item findByBarcode(String barcode) {
        return itemDAO.findByBarcode(barcode).toEntity();
    }
}
