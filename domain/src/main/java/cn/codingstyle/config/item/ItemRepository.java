package cn.codingstyle.config.item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    void save(Item item);

    Optional<Item> findById(int id);

    void delete(int id);

    boolean existByBarcode(String barcode);

    List<Item> findAll();
}
