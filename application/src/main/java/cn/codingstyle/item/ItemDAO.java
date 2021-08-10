package cn.codingstyle.item;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemDAO extends CrudRepository<ItemDO,Integer>{
    Optional<ItemDO> findByBarcode(String barcode);
}
