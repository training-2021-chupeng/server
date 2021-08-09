package cn.codingstyle.config.item;

import java.util.Optional;

public interface ItemRepository {
    void save(Item item);

    Optional<Item> findById(int id);

    void delete(int id);

    boolean existByBarcode(String barcode);

    boolean existById(int id);

    Item findByBarcode(String barcode);
}
