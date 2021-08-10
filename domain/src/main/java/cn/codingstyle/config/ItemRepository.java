package cn.codingstyle.config;

import java.util.Optional;

public interface ItemRepository {
    void save(Item item);

    Optional<Item> findById(int id);

    void delete(int id);

    Optional<Item> findByBarcode(String barcode);
}
