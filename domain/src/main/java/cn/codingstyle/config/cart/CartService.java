package cn.codingstyle.config.cart;

import cn.codingstyle.config.item.Item;
import cn.codingstyle.config.item.ItemRepository;

public class CartService {
    private final ItemRepository itemRepository;
    private final CartList cartList = new CartList();

    public CartService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public CartList addItem(String barcode, int num) {
        Item item = itemRepository.findByBarcode(barcode);
        cartList.add(num, item);
        return cartList;
    }
}
