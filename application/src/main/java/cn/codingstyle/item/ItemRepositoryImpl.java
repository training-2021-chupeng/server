package cn.codingstyle.item;

import cn.codingstyle.config.item.Item;
import cn.codingstyle.config.item.ItemRepository;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Item> findAll() {
        return Lists.newArrayList(itemDAO.findAll()).stream().map(ItemDO::toEntity).collect(Collectors.toList());
    }

}
