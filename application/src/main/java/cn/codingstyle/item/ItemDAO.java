package cn.codingstyle.item;

import cn.codingstyle.config.item.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDAO extends CrudRepository<ItemDO,Integer>{
    boolean existsByBarcode(String barcode);

    ItemDO findByBarcode(String barcode);
}
